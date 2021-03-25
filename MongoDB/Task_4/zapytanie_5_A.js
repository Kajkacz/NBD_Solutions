printjson(
    db.people.aggregate([
        {
            $match: {
                "sex": "Female",
                "nationality": "Poland",
            }
        },
        { $unwind: "$credit" },
        {
            $group: {
                _id: "$credit.currency",
                sum_credit: {
                    $sum: {
                        $toDouble: "$credit.balance"
                    }
                },
                avg_credit: {
                    $avg: {
                        $toDouble: "$credit.balance"
                    }
                }
            }
        },
    ])
);
