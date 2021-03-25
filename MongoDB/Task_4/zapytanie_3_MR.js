var mapFunction = function () {
    emit('jobs', this.job);
};

var reduceFunction = function (id, jobs) {
    var jobs_unique = {};
    var jobs_unique_array = [];
    jobs.forEach(function (job) {
        if (!jobs_unique[job])
            jobs_unique[job] = 0
        jobs_unique_array += job
    });

    return jobs_unique_array;

};
printjson(db.people.mapReduce(
    mapFunction,
    reduceFunction,
    {
        out: { inline: 1 },
    }
));