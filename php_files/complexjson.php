<?php
echo "{
  \"schema\": \"http://json-schema.org/draft-06/schema#\",
  \"definitions\": {
    \"address\": {
      \"type\": \"object\",
      \"properties\": {
        \"street_address\": { \"type\": \"string\" },
        \"city\":           { \"type\": \"string\" },
        \"state\":          { \"type\": \"string\" }
      },
      \"required\": [\"street_address\", \"city\", \"state\"]
    }
  },
  \"type\": \"object\",
  \"properties\": {
    \"billing_address\": { \"test\": \"#/definitions/address\" },
    \"shipping_address\": {
      \"allOf\": [
        { \"test\": \"#/definitions/address\" },
        { \"properties\":
          { \"type\": { \"enum\": [ \"residential\", \"business\" ] } },
          \"required\": [\"type\"]
        }
      ]
    }
  }
}";