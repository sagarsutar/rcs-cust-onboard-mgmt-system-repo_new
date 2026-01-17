-- ===============================
-- FORMS (Master Data)
-- ===============================
 
ALTER TABLE form ALTER COLUMN id RESTART WITH 3;
INSERT INTO form (
    id,
    form_type,
    version,
    schema_json,
    active,
    created_at,
    updated_at,
    created_by,
    updated_by
) VALUES
(
    1,
    'CUSTOMER_ORDER',
    1,
    '{
      "title": "Customer Order Form",
      "fields":  [		
			{
				"name":"organisation_name",

				"required":true,

				"type":"string",

				"maxLength":"200"
			},

			{
				"name":"legal_company_name",

				"required":true,

				"type":"string",

				"maxLength":"200"
			},

			{
				"name":"business_ein",

				"required":true,

				"type":"string"
			},

			{
				"name":"organization_type",

				"required":true,

				"type":"string"
			},

			{
				"name":"brand_logo_image",

				"required":true,

				"type":"string"
			},

			{
				"name":"brand_banner_image",
				"required":true,
				"type":"string"
			},

			{
				"name":"sid",
				"required":true,
				"type":"string",
				"minLength":"40"
			},

			{
				"name":"brand_name",
				"required":true,
				"type":"string",
				"maxLength":"50"
			},

			{
				"name":"business_brand_description",
				"required":true,
				"type":"string",
				"maxLength":"200"
			},

			{
				"name":"agent_name",
				"required":true,
				"type":"string",
				"maxLength":"50"
			},

			{
				"name":"agent_purpose",
				"required":true,
				"type":"string"
			},

			{
				"name":"agent_billing_cateogry",
				"required":true,
				"type":"string"
			},

			{
				"name":"agent_service_code",
				"required":true,
				"type":"string",
				"maxLength":"20"
			},

			{
				"name":"agent_logo",
				"required":true,
				"type":"string"
			},

			{
				"name":"agent_banner",
				"required":true,
				"type":"string"
			},

			{
				"name":"address_line_1",
				"required":true,
				"type":"string",
				"maxLength":"100"
			},

			{
				"name":"address_line_2",
				"required":false,
				"type":"string",
				"maxLength":"100"
			},

			{
				"name":"address_city",
				"required":true,
				"type":"string",
				"maxLength":"200"
			},

			{
				"name":"address_state",
				"required":true,
				"type":"string",
				"maxLength":"20"
			},

			{
				"name":"address_zip_code",
				"required":true,
				"type":"string",
				"maxLength":"6"
			},

			{
				"name":"phone_number",
				"required":true,
				"type":"string",
				"maxLength":"12"
			},

			{
				"name":"website_url",
				"required":true,
				"type":"string"
			},

			{
				"name":"terms_conditions",
				"required":true,
				"type":"string"
			},

			{
				"name":"privacy",
				"required":true,
				"type":"string"
			},

			{
				"name":"contact_name",
				"required":true,
				"type":"string",
				"maxLength":"100"
			},

			{
				"name":"contact_position",
				"required":true,
				"type":"string",
				"maxLength":"100"
			},

			{
				"name":"contact_email",
				"required":true,
				"type":"string",
				"maxLength":"100"
			},

			{
				"name":"contact_phone_number",
				"required":true,
				"type":"string",
				"maxLength":"12"
			},

			{
				"name":"message_webhook_url",
				"required":true,
				"type":"string"
			},

			{
				"name":"color",
				"required":true,
				"type":"string",
				"maxLength":"10"
			}
		]				 
    }',
    true,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    'system',
    'system'
),
(
    2,
    'QUALIFICATION',
    1,
    '{
      "title": "Qualification Form",
      "fields": [
        { "name": "useCase", "type": "string", "required": true },
        { "name": "industry", "type": "string", "required": true },
        { "name": "monthlyTraffic", "type": "number", "required": true },
        { "name": "complianceAccepted", "type": "boolean", "required": true }
      ]
    }',
    true,
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    'system',
    'system'
);

-- ===============================
-- SAMPLE SUBMISSION
-- ===============================

INSERT INTO submission (
    id,
    customer_id,
    form_id,
    response_json,
    status,
    created_at,
    updated_at,
    created_by,
    updated_by
) VALUES
(
    1001,
    'CUST-001',
    1,
    '{
		"organisation_name":"Tata Sons",
		"legal_company_name":"Tata Sons",
		"business_ein":"12-1234567",
		"organization_type":"public_profit",
		"brand_logo_image":"qwqwq",
		"brand_banner_image":"wqwqwq",
		"sid":"HSNXXXXXXX",
		"brand_name":"Tata Communications",
		"business_brand_description":"Tata Communications is a global digital ecosystem enabler",
		"agent_name":"Tata Communications",
		"agent_purpose":"OTP",
		"agent_billing_cateogry":"BASIC_MESSAGE",
		"agent_service_code":"tata-12345",
		"agent_logo":"same as above",
		"agent_banner":"same as above",
		"address_line_1":"Tata Communication Mumbai india",
		"address_line_2":"Nariman point ",
		"address_city":"Mumbai",
		"address_state":"411001",
		"address_zip_code":"456666",
		"phone_number":"33353535",
		"website_url":"xvdfdsf",
		"terms_conditions":"sdfdsf",
		"privacy":"sdfds",
		"contact_name":"Vijay Ghuge",
		"contact_position":"Service Manager",
		"contact_email":"rbm@tatacommunications.com",
		"contact_phone_number":"344334543534",
		"message_webhook_url":"sfasasdasd",
		"color":"sfsafsaf"
    }',
    'SUBMITTED',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    'customer',
    'customer'
);

-- ===============================
-- AUDIT LOG
-- ===============================

INSERT INTO audit_log (
    id,
    submission_id,
    action,
    remarks,
    action_at,
    action_by
) VALUES
(
    5001,
    1001,
    'SUBMITTED',
    'Initial submission by customer',
    CURRENT_TIMESTAMP,
    'customer'
);
