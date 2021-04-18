var mapFunction = function () {
    if (this.sex === "Female", this.nationality === "Poland")
        for (var i = 0; i < this.credit.length; i++) {
            balance = parseFloat(this.credit[i].balance)
            emit(this.credit[i].currency, {
                sum: balance,
                average: balance,
                count: 1,
                max: balance,
                min: balance,
            });
        };
}
var reduceFunction = function (id, balances) {
    let sum = 0
    let count = 0
    let average = 0
    var max = 0
    var min = 9999
    balances.forEach(function (balance) {
        count += balance.count;
        sum += balance.sum;
        if (balance.max > max)
            max = balance.max
        if (balance.min < min)
            min = balance.min
    });

    return {
        sum: sum,
        average: sum / count,
        count: count,
        max: max,
        min: min,
    }
};
var finalizeFunction = function (id, balances) {
    //CZY TU ZAWSZE MAMY 1 WARTOŚĆ?
    return {
        sum: balances.sum,
        average: balances.sum / balances.count,
        count: balances.count,
        max: balances.max,
        min: balances.min,
    }
};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        finalize: finalizeFunction,
        out: { inline: 1 },
    }
));