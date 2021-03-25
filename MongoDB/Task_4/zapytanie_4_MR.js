var mapFunction = function () {
    emit(this.nationality, this.weight * 10000 / (this.height * this.height));
};

var reduceFunction = function (id, bmis) {
    var max = 0
    var min = 9999
    bmis.forEach(function (bmi) {
        if (bmi > max)
            max = bmi
        if (bmi < min)
            min = bmi
    });

    return { average: Array.avg(bmis), max: max, min: min }

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: { inline: 1 },
    }
));