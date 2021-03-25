printjson(db.people.insertOne({
    "sex" : "Male",
    "first_name" : "Kajetan",
    "last_name" : "Kaczmarek",
    "job" : "Professional Can Opener",
    "email" : "pco@domain.com",
    "location" : {
            "city" : "Moon",
            "address" : {
                    "streetname" : "Sea of Tranquility",
                    "streetnumber" : "123"
            }
    },
    "description" : "Just a random nerd",
    "height" : "195",
    "weight" : "83",
    "birth_date" : "1993-10-15T14:15:03Z",
    "nationality" : "France",
    "credit" : [
            {
                    "type" : "switch",
                    "number" : "9128409182312315",
                    "currency" : "USD",
                    "balance" : "9000.01"
            }
    ]
}))