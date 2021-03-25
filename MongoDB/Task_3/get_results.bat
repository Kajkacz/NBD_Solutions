FOR /L %%A IN (1,1,10) DO (
    mongo nbd zapytanie_%%A.js > wyniki_%%A.json
)