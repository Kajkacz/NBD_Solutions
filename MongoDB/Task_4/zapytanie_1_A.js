printjson(db.people.aggregate(
    [
        {
            $group:
            {
                "_id": "$sex",
                avgWeight: {
                    $avg: {
                        $toDouble: "$weight"
                    }
                }
            }
        }
    ])
)