ALTER TABLE food ADD cost_kilo DECIMAL(15,4) NULL;
ALTER TABLE food DROP COLUMN price;

ALTER TABLE diet ADD total_cost_protein DECIMAL(15,4) NULL;
ALTER TABLE diet ADD total_cost_calorie DECIMAL(15,4) NULL;

ALTER TABLE diet_food ADD total_cost_protein DECIMAL(15,4) NULL;
ALTER TABLE diet_food ADD total_cost_calorie DECIMAL(15,4) NULL;