INSERT INTO organization( id, version, name ) VALUES ( 1, 0, 'Bannerman Community League' );

INSERT INTO venue( id, version, address, latitude, longitude, name ) VALUES ( 1, 0, '1234 100 Street NW', 12345678, 3312345, 'Bannerman Community Hall' );

INSERT INTO asset( id, version, area_in_venue, become_visible, become_invisible, cost, description, keywords, name, organization_id, phone_number, schedule, venue_id, website )
VALUES ( 1, 0, 'Community Room', '2015-12-18 00:00:00', '2019-12-18 00:00:00', 'Free', 'A one-hour class to help you do well at a job interview', 'hire', 'How to succeed in the Job Interview', 1, '780-123-4567', 'First Saturday morning of each month', 1, 'cbc.ca' );

INSERT INTO minor_asset_class( id, version, name, description, keywords ) VALUES ( 11, 0, 'Safe, affordable, quality housing', 'A decent place to live.', 'home apartment house' );

INSERT INTO asset_class_hierarchy( id, version, major_asset_class_id, minor_asset_class_id, sort_order ) VALUES ( 11, 0, 1, 11, 11 );

