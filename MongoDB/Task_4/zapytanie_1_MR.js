var mapFunction = function () {
    emit(this.sex, parseFloat(this.weight));
};

var reduceFunction = function (id, weight) {
    return Array.avg(weight);

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: { inline: 1 },
    }
));