var mapFunction = function () {
    emit(this.job, 1);
};

var reduceFunction = function (id, jobs) {

    return 1;

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: { inline: 1 },
    }
));