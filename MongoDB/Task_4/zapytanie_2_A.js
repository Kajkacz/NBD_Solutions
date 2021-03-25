printjson(
  db.people.aggregate([
    { $unwind: "$credit" },
    {
      $group: {
        _id: "$credit.currency",
        credit_left: {
          $sum: {
            $toDouble: "$credit.balance"
          }
        }
      }
    }
  ])
);
