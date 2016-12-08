package ph.edu.uplb.ics.cs191.randomquizgenerator;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "Quiz";
    private static final int DB_VERSION = 1;

    public QuizDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
            "CREATE TABLE QUESTION(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "QUESTION TEXT, " +
            "CHOICE_A TEXT, " +
            "CHOICE_B TEXT, " +
            "CHOICE_C TEXT, " +
            "CHOICE_D TEXT, " +
            "ANSWER TEXT);"
        );

        populateQuestions(db);

        db.execSQL(
            "CREATE TABLE HIGHSCORE(" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "NAME TEXT, " +
            "SCORE INT); "
        );

        populateHighscores(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertQuestion(SQLiteDatabase db, String question, String choiceA,String choiceB, String choiceC,String choiceD, String answer) {
        ContentValues questionInfo = new ContentValues();
        questionInfo.put("QUESTION", question);
        questionInfo.put("CHOICE_A", choiceA);
        questionInfo.put("CHOICE_B", choiceB);
        questionInfo.put("CHOICE_C", choiceC);
        questionInfo.put("CHOICE_D", choiceD);
        questionInfo.put("ANSWER", answer);

        db.insert("QUESTION", null, questionInfo);
    }

    public void editQuestion(SQLiteDatabase db, int id, String question, String[] choices, String answer) {
        ContentValues questionInfo = new ContentValues();
        questionInfo.put("QUESTION", question);
        questionInfo.put("CHOICE_A", choices[0]);
        questionInfo.put("CHOICE_B", choices[1]);
        questionInfo.put("CHOICE_C", choices[2]);
        questionInfo.put("CHOICE_D", choices[3]);
        questionInfo.put("ANSWER", answer);

        db.update("QUESTION", questionInfo, "_id=?", new String[]{String.valueOf(id)});
    }

    public void deleteQuestion(SQLiteDatabase db, int id) {
        db.delete("QUESTION", "_id=?", new String[]{String.valueOf(id)});
    }
    private void populateQuestions(SQLiteDatabase db) {
        insertQuestion(
                db,
                "How long ago did dinosaurs become extinct?",
                "10,000 years",
                "600,000 years",
                "6 million years",
                "60 million years",
                "D");
        insertQuestion(
                db,
                "Which of the following food items have the least calories?",
                "5 ounces of whole milk",
                "5 ounces of beer",
                "5 teaspoons of sugar",
                "5 ounces of vegetable oil",
                "B");
        insertQuestion(
                db,
                "The scapula is more commonly called the what?",
                "shoulder blade",
                "knee cap",
                "femur",
                "lower jaw bone",
                "A");
        insertQuestion(
                db,
                "At the time that the Large Electron-Positron Collider went into operation in 1989 it was the largest scientific instrument ever built with a circumference of over 16 mile. Where is it located?",
                "California and Nevada",
                "France and Switzerland",
                "Austria and Germany",
                "France and Italy",
                "B");
        insertQuestion(
                db,
                "If a circle and a square have the same area, then which of the following statements must be true?",
                "The circle's circumference is greater than the square's perimeter",
                "the circle's circumference is greater than the square's perimeter",
                "the circle's circumference is less than the square's perimeter",
                "None of the above",
                "C");
        insertQuestion(
                db,
                "Which of the following are true during a lunar eclipse?",
                "The sun is between the earth and the moon",
                "the earth is between the sun and the moon",
                "the sun is between the earth and the moon",
                "none of the above",
                "B");
        insertQuestion(
                db,
                "What kinds of quarks form the protons and neutrons in the atoms of matter?",
                "strange and charmed",
                "top and bottom",
                "up and down",
                "all of the above",
                "C");
        insertQuestion(
                db,
                "What country became the third one to launch a spacecraft to the moon in January 1990?",
                "China",
                "France",
                "Japan",
                "United Kingdom",
                "C");
        insertQuestion(
                db,
                "Which of the following flowers did not get its name from adding 'ia' to the surname of the botanist?",
                "fuchsia",
                "magnolia",
                "zinnia",
                "petunia",
                "D");
        insertQuestion(
                db,
                "What is an imaginary number?",
                "any irrational number",
                "any complex number",
                "the result of dividing any number by zero",
                "the square root of any negative real number",
                "D");
        insertQuestion(
                db,
                "Prior to 1977 rings were only known to exist around Saturn. Since then, at least one ring has been found around which other planet or planets?",
                "Jupiter, Uranus, and Neptune",
                "Uranus and Neptune",
                "Uranus",
                "Mercury and Neptune",
                "A");
        insertQuestion(
                db,
                "Which of these drugs was discovered first?",
                "aspirin",
                "cocaine",
                "penicillin",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "The Magellan spacecraft launched in 1989, was sent to map the surface of what planet?",
                " Mars",
                "Neptune",
                "Venus",
                "Mercury",
                "C");
        insertQuestion(
                db,
                "In computer software, how many bits are in a kilobyte?",
                "100",
                "1,000",
                "8,000",
                "8192",
                "D");
        insertQuestion(
                db,
                "In relativity theory, if a spaceship accelerated to near the speed of light, an observer not on the ship might notice all but which of the following?",
                "clocks on the ship would slow down",
                "the ship would get smaller",
                "the ship would lose mass",
                "the ship would gain mass",
                "C");
        insertQuestion(
                db,
                "Which of these animals lays eggs?",
                "Kangaroo",
                "koala",
                "platypus",
                "Tasmanian devil",
                "A");
        insertQuestion(
                db,
                "During which decade was the television invented?",
                "1920s",
                "1930s",
                "1940s",
                "1950s",
                "C");
        insertQuestion(
                db,
                "How many of the eight planets other than earth are smaller than Earth?",
                "0",
                "2",
                "4",
                "6",
                "C");
        insertQuestion(
                db,
                "Which of the following animals have, on the average, the shortest lifespan?",
                "gray squirrel",
                "grizzly bear",
                "kangaroo",
                "moose",
                "C");
        insertQuestion(
                db,
                "Which of the following gasses account for about 78 percent of the earth's atmosphere?",
                "argon",
                "carbon dioxide",
                "nitrogen",
                "oxygen",
                "C");
        insertQuestion(
                db,
                "What was the average life expectancy of white males born in the U.S just before the Civil War?",
                "40 years",
                "50 years",
                "60 years",
                "70 years",
                "A");
        insertQuestion(
                db,
                "What is a shaddock?",
                "a fish, the offspring of a male shad and a female haddock",
                "a crystal, such as quartz, that sticks out from a mineral vein",
                "a plant that is a member of the nightshade family",
                "a grapefruit",
                "D");
        insertQuestion(
                db,
                "Which one of the following instruments is used to measure humidity?",
                "anemometer",
                "ammeter",
                "hygrometer",
                "barometer",
                "C");
        insertQuestion(
                db,
                "Which two planets are most similar in size diameter wise?",
                "Mars and Mercury",
                "Venus and Earth",
                "Uranus and Neptune",
                "Jupiter and Saturn",
                "B");
        insertQuestion(
                db,
                "If a hertz is equal to one cylce per second, how manyh cycles per second does a megahertz  equal?",
                "1/1,000",
                "1,000",
                "1,000,000",
                "1,000,000,000",
                "C");
        insertQuestion(
                db,
                "What principle explains why cold food warms up and hot food cools off when stored at room temperature?",
                "entropy",
                "chemical equilibrium",
                "momentum",
                "relativity",
                "A");
        insertQuestion(
                db,
                "Which color is not considered to be one of the primary colors of light?",
                "Red",
                "yellow",
                "green",
                "blue",
                "B");
        insertQuestion(
                db,
                "What causes the disease toxoplasmosis?",
                "A bacterium",
                "a protozoan",
                "a virus",
                " a prion",
                "B");
        insertQuestion(
                db,
                "What is the slowest wind speed a hurricane can have according to the Saffir-Simpson scale?",
                "50 m.p.h.",
                "74 m.p.h.",
                "96 m.p.h.",
                "110 m.p.h.",
                "B");
        insertQuestion(
                db,
                "Which of the following heavenly bodies have never had a spacecraft landed on it?",
                "Venus",
                "Mars",
                "the moon",
                "Jupiter",
                "D");
        insertQuestion(
                db,
                "Meat should be kept frozen at what temperature in degrees Fahrenheit?",
                "0 degrees or below",
                "between 10 and 20 degrees",
                "between 20 and 30 degrees",
                "just below 32 degrees",
                "A");
        insertQuestion(
                db,
                "Many scientists think that some of the dinosaurs did not go extinct, but rather evolved into what kind of creature?",
                "amphibians",
                "reptiles",
                "birds",
                "mammals",
                "C");
        insertQuestion(
                db,
                "In 1989, scientists from Norway discovered that there are far more viruses in oceans, lakes, and streams than previously believed. How many viruses did they find that a milliliter of natural water might contain?",
                "up to 250",
                "up to 25,000",
                "up to 2,500,000",
                "up to 250,000,000",
                "D");
        insertQuestion(
                db,
                "In which kind of geometry is the sum of the angles inside a triangle exactly equal to 180 degrees?",
                "elliptical",
                "Euclidean",
                "hyperbolic",
                "linear",
                "B");
        insertQuestion(
                db,
                "What is the name of the disease that has been referred to as the 'disease of kings'?",
                "hemophilia",
                "jaundice",
                "rubella",
                "syphilis",
                "A");
        insertQuestion(
                db,
                "What disease causes a buildup of fluid pressure in the eyeball and damages the optic nerve at the back of the eye?",
                "astigmatism",
                "cataract",
                "glaucoma",
                "retinitis",
                "C");
        insertQuestion(
                db,
                "What would be the most likely thing one would do with the compound MgSO4 7H2O?",
                "power a car",
                "blow up a building",
                "soak ones feet",
                "fertilize a lawn",
                "C");
        insertQuestion(
                db,
                "Amps are a unit of measurement of what?",
                "electric charge",
                "electric current",
                "electric field strength",
                "electric potential",
                "B");
        insertQuestion(
                db,
                "In which century was the greatest number of chemical elements discovered?",
                "17th",
                "18th",
                "19th",
                "20th",
                "C");
        insertQuestion(
                db,
                "Louis Pasteur developed which vaccine?",
                "polio",
                "rabies",
                "smallpox",
                "anthrax",
                "B");

        insertQuestion(
                db,
                "Approximately when was the wheel invented?",
                "5500B.C.",
                "4500 B.C.",
                "3500B.C.",
                "1500 B.C.",
                "C");
        insertQuestion(
                db,
                "In chemistry, what element is represented by the symbol C?",
                "calcium",
                "carbon",
                "chlorine",
                "copper",
                "B");
        insertQuestion(
                db,
                "How many sides does a dodecagon have?",
                "10",
                "12",
                "15",
                "20",
                "B");
        insertQuestion(
                db,
                "Which of the following animals usually weighs the least?",
                "lions",
                "polar bears",
                "tigers",
                "Wildebeest",
                "A");
        insertQuestion(
                db,
                "Ice Age patterns of the last half million years indicate that the next Ice Age is due to arrive when?",
                "sometime between 10,000 to 30,000 years from now",
                "sometime between 50,000 to 100,000 years from now.",
                "sometime in the next 2,000 years",
                "over 100,000 years from now",
                "C");
        insertQuestion(
                db,
                "Which two different species of animals were successfully bred by the University of California?",
                "a goat and a sheep producing a new animal called a 'geep'",
                "a rabbit and a hamster, producing a new animal called a 'ramster'",
                "a horse and a camel, producing a new animal called a 'hormel'",
                "a deer and an elk , producing a new animal called a 'Delk'",
                "A");
        insertQuestion(
                db,
                "What was the name of the space shuttle that place in April, 1981 and was the first manned U.S. space shuttle flight?",
                "Atlantis",
                "Discovery",
                "Columbia",
                "Challenger",
                "C");
        insertQuestion(
                db,
                "Room temperature is about 68 degrees Fahrenheit. What is the temperature given in degrees Celsius?",
                "20 ",
                "30",
                "40",
                "50",
                "A");
        insertQuestion(
                db,
                "What was the name of the first U.S. Space Shuttle to take flight in April, 1981?",
                "Atlantis",
                "Columbia ",
                "Challenger",
                "Discovery",
                "B");
        insertQuestion(
                db,
                "According to a 1980s survey of 40,000 students, approximately what fraction of American school children now have no decay in their permanent teeth?",
                "one tenth",
                "one quarter",
                "one third",
                "one half ",
                "D");
        insertQuestion(
                db,
                "In the manufacturing of pewter what is the main ingredient?",
                "copper",
                "iron",
                "lead",
                "tin ",
                "D");
        insertQuestion(
                db,
                "How many sides does a dodecagon have?",
                "101",
                "12 ",
                "15",
                "20",
                "B");
        insertQuestion(
                db,
                "Roughly how much does a cubic foot of water weigh?",
                "10 pounds",
                "37 pounds",
                "62 pounds",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "What planet has a day that lasts only 10 hours?",
                "Mars",
                "Mercury",
                "Jupiter ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "How long did it take the voyager 2 spacecraft to reach Netpune?",
                "6 months",
                "3 years",
                "12 years ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Which one of the following laws of heredity are not one of Gregor  Mendel's laws?",
                "dominance",
                "independent  assortment",
                "integration ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "From the pit of what fruit does the controversial cancer-treating drug Laetrile come from?",
                "apricot ",
                "cherry",
                "peach",
                "watermelon",
                "A");
        insertQuestion(
                db,
                "How many years has the Amazon rain forest existed?",
                "10,000 ",
                "100,000",
                "1,000,000",
                "10,000,000",
                "A");
        insertQuestion(
                db,
                "The spaceship Voyager2 found geysers on Triton, a moon of what planet?",
                "Saturn",
                "Uranus",
                "Neptune ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "What are 'pre-clinical trials' in the process of testing new drugs before they are approved for general use?",
                "test by computer simulation of molecular interactions",
                "tests on animals ",
                "tests on humans",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "What African country is the Central Kalahari Game Reserve located in?",
                "Botswana",
                "Nigeria",
                "South Africa",
                "Kenya",
                "A");
        insertQuestion(
                db,
                "What is the function served by the Paris building known as the Sorbonne?",
                "hospital",
                "school",
                "museum",
                "theater",
                "B");
        insertQuestion(
                db,
                "Which one of the following countries is not known as one of the Baltic states?",
                "Albania",
                "Estonia",
                "Latvia",
                "Lithuania",
                "A");
        insertQuestion(
                db,
                "Which one of the following countries was not one of Germany's allies?",
                "Italy",
                "Bulgaria",
                "Turkey",
                "Austria-Hungary",
                "D");
        insertQuestion(
                db,
                "The Gunpowder Plot conspirators tried to kill what ruler along with members of Parliament in 1605?",
                "Charles I",
                "Elizabeth I",
                "Henry VIII",
                "James I",
                "D");
        insertQuestion(
                db,
                "Who enters the annual Van Cliburn International  Competition?",
                "chefs",
                "chess players",
                "pianists",
                "squash players",
                "C");
        insertQuestion(
                db,
                "The surrender of Germany in 1945 ended the Third Reich, when did the Second Reich end?",
                "1453",
                "1871",
                "1918",
                "1933",
                "C");
        insertQuestion(
                db,
                "By the time Nelson Mandela was freed in 1990, how long had he been in prison?",
                "7 years",
                "17 years",
                "27 years",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Violeta Barrios de Chamorro defeated whom in a 1989 presidential election?",
                "Alfredo Cristiani",
                "Daniel Ortega",
                "Jose Sarney",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "Which of the following countries does not border Israel?",
                "Egypt",
                "Jordan",
                "Saudi Arabia",
                "Syria",
                "C");
        insertQuestion(
                db,
                "What European capital city is located at the mouth of the Liffey River?",
                "Amsterdam",
                "Copenhagen",
                "Dublin",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Ulan Bator is the capital of what country?",
                "Madagascar",
                "Mali",
                "Mongolia",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Austria and which other country are connected by the Brenner Pass?",
                "Hungary",
                "Italy",
                "Switzerland",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "Mount Erebus is what?",
                "an active volcano in the Antarctica",
                "an underwater peak off Greece that is a hazard to Mediterranean shipping",
                "a nearly 17,000-foot peak on the Iran-Turkey border, where Noah's Ark  may have landed",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Who wrote some of the Flash Gordon comic strips that appeared in Europe during World War II?",
                "Buster Crabbe",
                "Charles DeGaulle",
                "Federico Fellini",
                "Hermann Hesse",
                "C");
        insertQuestion(
                db,
                "When added together, which two countries have over 90 percent of the world's platinum reserves?",
                "Australia and south Africa",
                "Canada and the United States",
                "South Africa and the Soviet Union",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "What two countries border the Dead Sea?",
                "Israel and Egypt",
                "Israel and Jordan",
                "Jordan and Saudi Arabia",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "What industry supplies Botswana with more than 75% of its total revenue?",
                "cattle",
                "coffee",
                "diamonds",
                "tourism",
                "C");
        insertQuestion(
                db,
                "Jack the Ripper terrorized what city in the 19th century?",
                "Belfast",
                "London",
                "New York",
                "San Francisco",
                "B");
        insertQuestion(
                db,
                "The United Nations had 51 members when i was founded in 194How many members does it have now?",
                "59",
                "109",
                "159",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Which of the following vegetables is not one of the ingredients of V-8 juice?",
                "beet",
                "carrot",
                "spinach",
                "cabbage",
                "D");
        insertQuestion(
                db,
                "What is the main ingredient in vichyssoise?",
                "lima beans",
                "clams",
                "tomatoes",
                "potatoes",
                "D");
        insertQuestion(
                db,
                "What country produces the most potatoes?",
                "China",
                "United States",
                "Ireland",
                "Yo' Mama",
                "A");
        insertQuestion(
                db,
                "What soft-drink company introduced the brand Slice?",
                "Pepper",
                "Coca Cola ",
                "Seven Up",
                "Pepsico",
                "D");
        insertQuestion(
                db,
                "According to a 1980s Beverage Media poll of four hundred bartenders, what is the average male customers favorite drink?",
                "beer ",
                "bourbon",
                "scotch",
                "vodka",
                "A");
        insertQuestion(
                db,
                "According to a 1980s Beverage Media poll of four hundred bartenders, what was the female customers favorite drink?",
                "beer",
                "margarita",
                "peach schnapps and orange juice",
                "white wine ",
                "D");
        insertQuestion(
                db,
                "Simplesse is NutraSweet's fat substitute What is it made of?",
                "a blend of proteins from egg white and milk ",
                "fat molecules altered to be too large to digest",
                "molecules that are the mirror-image of normal fat molecules",
                "Yo' Mama",
                "A");
        insertQuestion(
                db,
                "Which grade of olive oil is considered the best?",
                "extra virgin ",
                "pure virgin",
                "superfine virgin",
                "Yo' Mama",
                "A");
        insertQuestion(
                db,
                "What vegetable has varieties known as Bell Tower, Orobelle, and Jupiter?",
                "Onion",
                "pepper ",
                "squash",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "In the drink called a zombie, what is the main alcoholic ingredient?",
                "beer",
                "brandy",
                "rum",
                "whiskey",
                "C");
        insertQuestion(
                db,
                "Of the following dishes, which are not typically made with some kind of seafood?",
                "Bouillabaisse",
                "osso buco ",
                "fritto misto",
                "tempura",
                "B");
        insertQuestion(
                db,
                "Which of the following ingredients are not used in a Bloody Mary according to Playboy Bar Guide?",
                "ketchup",
                "sugar ",
                "Tabasco sauce",
                "Worcestershire sauce",
                "B");
        insertQuestion(
                db,
                "Which of the following compounds have not been approved for use in the U.S as an artificial sweetener?",
                "acesulfame K",
                "acetaminophen ",
                "aspartame",
                "saccharine",
                "B");
        insertQuestion(
                db,
                "The original Bellini was a mixture of sparkling Italian white wine and what type of fruit juice?",
                "apple",
                "orange",
                "peach ",
                "pomegranate",
                "C");
        insertQuestion(
                db,
                "The sandwich known as the 'Reuben' does not have which of the following ingredients?",
                "boiled ham ",
                "corned Beef",
                "sauerkraut",
                "Swiss Cheese",
                "A");
        insertQuestion(
                db,
                "Marzipan is made with what kind of nut?",
                "almond ",
                "cashew",
                "pecan",
                "walnut",
                "A");
        insertQuestion(
                db,
                "Which of the following is not a favorable adjective when discussing wine?",
                "fat ",
                "flinty",
                "leggy",
                "vigorous",
                "A");
        insertQuestion(
                db,
                "Of all commercial cooking oils, which of these is highest in polyunsaturates  and lowest in saturated fat?",
                "coconut oil",
                "corn oil",
                "olive oil",
                "safflower oil ",
                "D");
        insertQuestion(
                db,
                "In the United States, about how much beer does the average person drink each year?",
                "24 pints",
                "24 quarts",
                "24 gallons ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Europeans first learned of chocolate from whom?",
                "Africans",
                "Aztecs",
                "East Indians",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "What did 'Weird Al' Yankovic call his album that contained a parody of a song from Michael Jackson's album BAD?",
                "Baddest",
                "Even Worse",
                "Badder",
                "Good",
                "B");
        insertQuestion(
                db,
                "What band leader was known as 'the King of Swing'?",
                "Tommy Dorsey",
                "Benny Goodman ",
                "Guy Lombardo",
                "Glenn Miller",
                "B");
        insertQuestion(
                db,
                "Which one of these four Australian terms can be found in the lyrics of the song 'Waltzing Matilda' is a tree?",
                "billabong",
                "coolibah ",
                "jumbuck",
                "tucker-bag",
                "B");
        insertQuestion(
                db,
                "Which of the following musicals was based on Thornton Wilder's comedy The Matchmaker?",
                "Hello, Dolly! ",
                "The Music Man",
                "Take Me Along",
                "The Unsinkable Molly Brown",
                "A");
        insertQuestion(
                db,
                "What symphony's last movement includes a setting of Schiller's poem 'Hymn to Joy'?",
                "Beethoven's Ninth ",
                "Bruckner's Eight",
                "Mahler's Tenth",
                "Mozart's 40th",
                "A");
        insertQuestion(
                db,
                "Gloria Estefan broke her back in what kind of accident?",
                "She fell off a stage",
                "She was in a helicopter crash",
                "A tour bus accident",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "The lyrics 'By the time we got to Woodstock, we were half a million strong' were written by whom?",
                "Judy Collins",
                "David Crosby",
                "Joni Mitchell",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "Raffi is known for writing and singing what?",
                "children's songs",
                "New Age Music ",
                "rap music",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "What does Tosca throw from the roof of the prison at the end of the opera Tosca?",
                "her handkerchief",
                "her roses",
                "herself ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "What does Don Giovanni descend into at the end of the opera Don Giovanni?",
                "hell",
                "insanity",
                "prison",
                "Yo' Mama",
                "A");
        insertQuestion(
                db,
                "The sonnet that starts out 'The world is charged with the grandeur of God' was written by whom?",
                "Gerard Manley Hopkins ",
                "Henry Wadsworth Longfellow",
                "Alfred, Lord Tennyson",
                "Oscar Wilde",
                "A");
        insertQuestion(
                db,
                "'A wandering minstrel and 'Titwillow' are songs contained in which comic opera by Gilbert and Sullivan?",
                "The Gondoliers",
                "The Mikado ",
                "H.M. Pinafore",
                "The Pirates of Penzance",
                "B");
        insertQuestion(
                db,
                "In music, which of the following are 'accidentals'?",
                "finger cymbals and castanets",
                "mistakes made while playing",
                "sharps and flats ",
                "Yo' Mama",
                "C");
        insertQuestion(
                db,
                "In the Opera Faust, Faust wins Marguerite's love with what?",
                "candy",
                "jewelry ",
                "roses",
                "Yo' Mama",
                "B");
        insertQuestion(
                db,
                "The piano piece known as 'The Minute Waltz' was written by whom?",
                "Johannes Brahms",
                "Frederic  Chopin",
                "Franz Liszt",
                "Sergei Rachmaninoff",
                "B");
        insertQuestion(
                db,
                "The musical work, The Sorcerer's Apprentice, was written by whom?",
                "Paul Dukas  ",
                "Wolfgang Amadeus Mozart",
                "Maurice Ravel",
                "Camille Saint-Saens",
                "A");
        insertQuestion(
                db,
                "What song writer wrote the song with the line 'Mad dogs and Englishmen go out in the mid-day sun' in it?",
                "Noel Coward ",
                "Gilbert and Sullivan",
                "Cole Porter",
                "Yo' Mama",
                "A");
        insertQuestion(
                db,
                "Whose debut album 'Forever Your Girl' sold over 5,000,000 albums?",
                "Paula Abdul ",
                "Sade",
                "Tiffany",
                "Yo' Mama",
                "A");
        insertQuestion(
                db,
                "A song called 'Party All the Time', released in 1985, reached the # 2 spot on Billboard's pop chart; Which Saturday Night Live actor recorded the song?",
                "Garrett Morris",
                "Eddie Murphy",
                "Bill Murray",
                "Joe Piscopo",
                "B");
        insertQuestion(
                db,
                "Two of Barbara Cook's most popular songs, 'Dear Friend' and Vanilla Ice Cream', were provided by what musical?",
                "Candide",
                "Carousel",
                "The Music Man",
                "She Loves Me",
                "D");
    }

    public void insertHighscore(SQLiteDatabase db, String name, int score) {
        ContentValues highscoreInfo = new ContentValues();
        highscoreInfo.put("NAME", name);
        highscoreInfo.put("SCORE", score);

        db.insert("HIGHSCORE", null, highscoreInfo);
    }
    private void populateHighscores(SQLiteDatabase db) {

    }

}
