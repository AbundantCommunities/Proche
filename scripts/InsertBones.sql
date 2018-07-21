INSERT INTO tag( id, version, text, date_created, last_updated ) VALUES( 1, 0, 'brillig', NOW(), NOW() );
INSERT INTO tag( id, version, text, date_created, last_updated ) VALUES( 2, 0, 'slithy',  NOW(), NOW() );

INSERT INTO tag_asset( id, version, tag_id, asset_id, sort_order ) VALUES( 1, 0, 1, 20, 100 );
INSERT INTO tag_asset( id, version, tag_id, asset_id, sort_order ) VALUES( 2, 0, 1, 21, 200 );
INSERT INTO tag_asset( id, version, tag_id, asset_id, sort_order ) VALUES( 3, 0, 1, 111, 300 );
INSERT INTO tag_asset( id, version, tag_id, asset_id, sort_order ) VALUES( 4, 0, 2, 21, 100 );
INSERT INTO tag_asset( id, version, tag_id, asset_id, sort_order ) VALUES( 5, 0, 2, 52, 200 );

INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 1, 0, 'Bannerman', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 2, 0, 'Clareview Campus', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 3, 0, 'Fraser', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 4, 0, 'Hairsine', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 5, 0, 'Kirkness', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 6, 0, 'Kernohan', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 7, 0, 'Homesteader', CURRENT_DATE, CURRENT_DATE );
INSERT INTO community( id, version, name, date_created, last_updated ) VALUES( 8, 0, 'Canon Ridge', CURRENT_DATE, CURRENT_DATE );

INSERT INTO category( id, version, name, description, date_created, last_updated ) VALUES( 1, 0, 'Housing (Affordable)', 'Affordable housing', CURRENT_DATE, CURRENT_DATE );
INSERT INTO category( id, version, name, description, date_created, last_updated ) VALUES( 2, 0, 'Day care', 'Child care during working hours', CURRENT_DATE, CURRENT_DATE );
INSERT INTO category( id, version, name, description, date_created, last_updated ) VALUES( 3, 0, 'Christian worship', 'Catholic, Protestant, etc', CURRENT_DATE, CURRENT_DATE );
INSERT INTO category( id, version, name, description, date_created, last_updated ) VALUES( 4, 0, 'Music classes', 'Learn an instrument, learn to sing, etc.', CURRENT_DATE, CURRENT_DATE );

INSERT INTO asset_categories( asset_id, category_id ) VALUES( 97, 4 ); /* Suzuiki Piano School :: Music classes */
INSERT INTO asset_categories( asset_id, category_id ) VALUES( 39, 1 ); /* Affordable housing */
INSERT INTO asset_categories( asset_id, category_id ) VALUES( 47, 1 ); /* Affordable housing */
INSERT INTO asset_categories( asset_id, category_id ) VALUES( 42, 1 ); /* Affordable housing */
INSERT INTO asset_categories( asset_id, category_id ) VALUES( 43, 1 ); /* Affordable housing */

INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 11, 0, 1, 11, 11, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 12, 0, 1, 12, 12, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 13, 0, 1, 13, 13, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 14, 0, 1, 14, 14, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 15, 0, 1, 15, 15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 16, 0, 1, 16, 16, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );

INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 21, 0, 2, 21, 21, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 22, 0, 2, 22, 22, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 24, 0, 2, 24, 24, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 26, 0, 2, 26, 26, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 27, 0, 2, 27, 27, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 28, 0, 2, 28, 28, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );

INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 31, 0, 3, 31, 31, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 32, 0, 3, 32, 32, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 33, 0, 3, 33, 33, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 34, 0, 3, 34, 34, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 35, 0, 3, 35, 35, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 36, 0, 3, 36, 36, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );

INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 41, 0, 4, 41, 41, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 42, 0, 4, 42, 42, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 43, 0, 4, 43, 43, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 44, 0, 4, 44, 44, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 45, 0, 4, 45, 45, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 46, 0, 4, 46, 46, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 47, 0, 4, 47, 47, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );

INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 51, 0, 5, 51, 51, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 52, 0, 5, 52, 52, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 53, 0, 5, 53, 53, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 54, 0, 5, 54, 54, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 55, 0, 5, 55, 55, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
INSERT INTO honey_node( id, version, major_asset_class_id, minor_asset_class_id, sort_order, date_created, last_updated ) VALUES ( 56, 0, 5, 56, 56, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
