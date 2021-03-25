var mapFunction = function () {
    if (this.sex === "Female", this.nationality === "Poland")
        for (var i = 0; i < this.credit.length; i++) {
            emit(this.credit[i].currency, parseFloat(this.credit[i].balance));
        };
}
var reduceFunction = function (id, balances) {

    return { average: Array.avg(balances), sum: Array.sum(balances) }
};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: { inline: 1 },
    }
));