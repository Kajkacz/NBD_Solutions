var mapFunction = function () {
    let bmi = this.weight * 10000 / (this.height * this.height);
    emit(
        this.nationality,
        { average: { sum: bmi, count: 1 }, max: bmi, min: bmi }
    );
};

var reduceFunction = function (id, bmis) {
    var max = 0
    var count = 0
    var min = 9999
    var sum = 0

    bmis.forEach(function (bmi) {
        count++;
        sum += bmi.average.sum
        if (bmi.max > max)
            max = bmi.max
        if (bmi.min < min)
            min = bmi.min
    });
    return { average: { sum: sum, count: count }, max: max, min: min }

};
var finalizeFunction = function (id, doc) {
    let output = doc.average.sum / doc.average.count

    return { average: output, max: doc.max, min: doc.min }

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        finalize: finalizeFunction,
        out: { inline: 1 },
    }
));