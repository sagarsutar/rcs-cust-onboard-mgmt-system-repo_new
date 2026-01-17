package com.tcl.assignemnt.validation;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.tcl.assignemnt.exception.ValidationException;
import com.tcl.assignemnt.model.FormSubmission;

public  class JsonSchemaValidationClass {
	
	public static void validateAgainstSchema(FormSubmission submission) {

	    try {
	        ObjectMapper mapper = new ObjectMapper();
          //   System.out.println(submission.getForm().getSchemaJson());
	        JsonNode schemaNode = mapper.readTree(submission.getForm().getSchemaJson());
	        JsonNode payloadNode = mapper.readTree(submission.getResponseJson());
	       
	        System.out.println("payloadNode" + submission.getResponseJson()); 
	      
	        ArrayNode fields = (ArrayNode) schemaNode.get("fields");

	        for (JsonNode field : fields) {
	            String fieldName = field.get("name").asText();
	            boolean required = field.path("required").asBoolean(false);

	            JsonNode valueNode = payloadNode.get(fieldName);
	            System.out.println("----- fieldName " + fieldName);
	            System.out.println("----- valueNode " + valueNode);
	           
	            if (required && (valueNode == null || valueNode.isNull())) {
	                throw new ValidationException(fieldName + " is mandatory");
	            }

	            if (valueNode == null || valueNode.isNull()) {
	                continue; // optional and not provided
	            }
 
	            validateType(field, valueNode, fieldName);

	         
	            validateConstraints(field, valueNode, fieldName);
	        }

	    } catch (IOException e) {
	        throw new ValidationException("Invalid form schema or payload format");
	    }
	}
	public static void validateType(JsonNode field, JsonNode valueNode, String fieldName) {

	    String type = field.get("type").asText();

	    switch (type) {
	        case "string":
	            if (!valueNode.isTextual()) {
	                throw new ValidationException(fieldName + " must be a string");
	            }
	            break;

	        case "number":
	            if (!valueNode.isNumber()) {
	                throw new ValidationException(fieldName + " must be a number");
	            }
	            break;

	        case "boolean":
	            if (!valueNode.isBoolean()) {
	                throw new ValidationException(fieldName + " must be boolean");
	            }
	            break;

	        default:
	            throw new ValidationException("Unsupported type: " + type);
	    }
	}
	public static void validateConstraints(JsonNode field, JsonNode valueNode, String fieldName) {

	    if (valueNode.isTextual()) {

	        int length = valueNode.asText().length();

	        if (field.has("maxLength") && length > field.get("maxLength").asInt()) {
	            throw new ValidationException(
	                fieldName + " exceeds max length " + field.get("maxLength").asInt()
	            );
	        }

	        if (field.has("minLength") && length < field.get("minLength").asInt()) {
	            throw new ValidationException(
	                fieldName + " below min length " + field.get("minLength").asInt()
	            );
	        }
	    }

	    if (valueNode.isNumber()) {

	        double value = valueNode.asDouble();

	        if (field.has("min") && value < field.get("min").asDouble()) {
	            throw new ValidationException(
	                fieldName + " must be >= " + field.get("min").asDouble()
	            );
	        }

	        if (field.has("max") && value > field.get("max").asDouble()) {
	            throw new ValidationException(
	                fieldName + " must be <= " + field.get("max").asDouble()
	            );
	        }
	    }
	}

}
