FOR /L %%A IN (1,1,5) DO (
    mongo nbd zapytanie_%%A_MR.js > wyniki_%%A_MR.json
    mongo nbd zapytanie_%%A_A.js > wyniki_%%A_A.json
)