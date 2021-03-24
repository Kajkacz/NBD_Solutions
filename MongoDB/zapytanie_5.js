db.people.find({}, {"first_name" : 1,"last_name" : 1, "location.city" : 1}) //TODO Jak to poprawić dla tego XXI wieku narodzin?  
db.people.find({}, {"first_name" : 1,"last_name" : 1, "location" : {"city" : 1})    ///CZEMU TO NIE DZIAŁA 
