var mapFunction = function () {
    for (var i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance));
    }
};

var reduceFunction = function (id, balance) {
    return Array.sum(balance);

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: { inline: 1 },
    }
));