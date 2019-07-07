package com.mygdx.game.Outils;

import java.util.Locale;

public class Translator {

    private String fichePilote1;
    private String fichePilote2;
    private String fichePilote3;
    private String fichePilote4;
    private String fichePilote5;
    private String fichePilote6;
    private String fichePilote7;
    private String fichePilote8;
    private String fichePilote9;
    private String fichePilote10;
    private String fichePilote11;
    private String fichePilote12;

    private String ficheVehicule1;
    private String ficheVehicule2;
    private String ficheVehicule3;
    private String ficheVehicule4;
    private String ficheVehicule5;
    private String ficheVehicule6;
    private String ficheVehicule7;
    private String ficheVehicule8;
    private String ficheVehicule9;
    private String ficheVehicule10;
    private String ficheVehicule11;
    private String ficheVehicule12;

    private String ficheCircuit1;
    private String ficheCircuit2;
    private String ficheCircuit3;
    private String ficheCircuit4;
    private String ficheCircuit5;
    private String ficheCircuit6;
    private String ficheCircuit7;
    private String ficheCircuit8;
    private String ficheCircuit9;
    private String ficheCircuit10;
    private String ficheCircuit11;
    private String ficheCircuit12;

    private String sauvegarder;

    private String boutonMenuGeneralPilote;
    private String boutonMenuGeneralVehicule;
    private String boutonMenuGeneralCircuit;
    private String boutonMenuGeneralBoutique;
    private String boutonMenuGeneralAtelier;

    private String boutonMenu;
    private String boutonReplay;
    private String boutonResume;

    private String panneTimerLabel;
    private String secondes;
    private String ready;

    private String trophee;

    private String manqueArgent;

    private String timerDecompte;

    private String ficheComptePart1;
    private String ficheComptePart2;
    private String ficheComptePart3;
    private String ficheComptePart4;
    private String ficheComptePart5;
    private String ficheComptePart6;
    private String ficheComptePart7;
    private String ficheComptePart8;
    private String ficheComptePart9;
    private String ficheComptePart10;
    private String ficheComptePart11;

    private String popUpWifiLabelPart1;
    private String popUpWifiLabelPart2;
    private String popUpWifiLabelPart3;
    private String popUpWifiLabelPart4;

    // FR
    private String fichePilote1FR = "Il glisse sur les epaves\n" + "comme sur des vagues !";
    private String fichePilote2FR = "Il va tous les manger\n" + "tout cru !";
    private String fichePilote3FR = "Un broyeur\n" + "prehistorique de\n" + "7 tonnes !";
    private String fichePilote4FR = "La moto des chevaliers...";
    private String fichePilote5FR = "Le petit-fils du\n" + "Triceratops ... moins ...\n" + " 1 corne !";
    private String fichePilote6FR = "A 2 pour cent pres,\n" + "on avait le meme ADN !";
    private String fichePilote7FR = "Doucement mais surement,\n" + "elle gagne du temps...";
    private String fichePilote8FR = "Le symbole de tous\n" + "les rockers !";
    private String fichePilote9FR = "Aucun oiseau ne resiste\n" + "a son charme";
    private String fichePilote10FR = "Il fait regner l'ordre\n" + "dans la basse-cour !";
    private String fichePilote11FR = "Ne lui tendez pas la\n" + "main, sauf si vous n'en\n" + "avez plus besoin !";
    private String fichePilote12FR = "Une grosse peluche\n" + "qui met des giga-baffes !";

    private String ficheVehicule1FR = "On avait pas moins\n" + "cher !";
    private String ficheVehicule2FR = "Elle peut surprendre !";
    private String ficheVehicule3FR = "La fougue de la jeunesse !";
    private String ficheVehicule4FR = "La plus nerveuse\n" + "du circuit !";
    private String ficheVehicule5FR = "Luxueuse... et boueuse...";
    private String ficheVehicule6FR = "Explose ses ennemis\n" + "avec tact...";
    private String ficheVehicule7FR = "Mefiez-vous des anciens !";
    private String ficheVehicule8FR = "Il domine les champs !";
    private String ficheVehicule9FR = "Ne restez pas allonger\n" + "sur vos serviettes !";
    private String ficheVehicule10FR = "Rien ne l'arrete !";
    private String ficheVehicule11FR = "Un poids lourd, un vrai !";
    private String ficheVehicule12FR = "Cree pour ecraser !";

    private String ficheCircuit1FR = "Attention dans\n" + "la descente !";
    private String ficheCircuit2FR = "N'oubliez pas\n" + "votre bouteille d'eau !";
    private String ficheCircuit3FR = "Un petit pas pour\n" + "l'animal, un grand bond\n" + "pour le Monster truck";
    private String ficheCircuit4FR = "Plutot flippant...\n" + "surtout la nuit...";
    private String ficheCircuit5FR = "La foret de tous\n" + "les dangers !";
    private String ficheCircuit6FR = "Quand le paradis\n" + "devient enfer...";
    private String ficheCircuit7FR = "La ville est une jungle !";
    private String ficheCircuit8FR = "On est tellement\n" + "mieux à la campagne...";
    private String ficheCircuit9FR = "Un autre monde,\n" + "des kilometres sous\n" + "la surface";
    private String ficheCircuit10FR = "Ideal pour les vacances\n" + "en famille !";
    private String ficheCircuit11FR = "Il faut etre un pingouin\n" + "pour vivre ici !";
    private String ficheCircuit12FR = "Apportez votre\n" + "masque a gaz !";

    private String sauvegarderFR = "SAUVEGARDER";

    private String boutonMenuGeneralPiloteFR = "PILOTE";
    private String boutonMenuGeneralVehiculeFR = "VEHICULE";
    private String boutonMenuGeneralCircuitFR = "CIRCUIT";
    private String boutonMenuGeneralBoutiqueFR = "BOUTIQUE";
    private String boutonMenuGeneralAtelierFR = "ATELIER";

    private String boutonMenuFR = "MENU";
    private String boutonReplayFR = "REJOUER";
    private String boutonResumeFR = "CONTINUER";

    private String panneTimerLabelFR = "il vous reste ";
    private String secondesFR = " secondes";
    private String readyFR = "PRET ?";

    private String tropheeFR = " trophee";

    private String manqueArgentFR = "il vous manque";

    private String timerDecompteFR = "   vous avez regarde\n"+"    10 videos en 2h,\n"+" vous devez attendre";

    private String ficheComptePart1FR = "Argent : ";
    private String ficheComptePart2FR = "( somme maximum gagnéee au cours d'une partie )";
    private String ficheComptePart3FR = "Nombre de Trophee Roue : ";
    private String ficheComptePart4FR = "( Record de trophee obtenu en ecrasant un max de vehicules )";
    private String ficheComptePart5FR = "Nombre de Trophee Dollar : ";
    private String ficheComptePart6FR = "( Record de trophee obtenu en gagnant plus de 3500 $ ";
    private String ficheComptePart7FR = " durant une partie )";
    private String ficheComptePart8FR = "Nombre de Trophee Bonus : ";
    private String ficheComptePart9FR = "( Record de trophee obtenu en recuperant les bonus : ";
    private String ficheComptePart10FR = " gazole gratuit, billet de 100$ et nitro )";
    private String ficheComptePart11FR = "Argent Max : ";

    private String popUpWifiLabelPart1FR = "   vous devez etre";
    private String popUpWifiLabelPart2FR = " connecte en wifi ";
    private String popUpWifiLabelPart3FR = "    pour regarder ";
    private String popUpWifiLabelPart4FR = "        des videos";

    // EN
    private String fichePilote1EN = "It slides on wrecks\n" + "like waves !";
    private String fichePilote2EN = "He's going to eat them\n" + "all raw !";
    private String fichePilote3EN = "A prehistoric 7-ton\n" + "crusher !";
    private String fichePilote4EN = "The knights'\n" + " motorcycle....";
    private String fichePilote5EN = "The grandson of the\n" + "Triceratops... minus\n" + "1 horn !";
    private String fichePilote6EN = "Within two percent,\n" + "we had the same DNA !";
    private String fichePilote7EN = "Slowly but surely,\n" + "she saves time...";
    private String fichePilote8EN = "The symbol of all\n" + "rockers !";
    private String fichePilote9EN = "No bird can resist\n" + "its charm";
    private String fichePilote10EN = "He keeps order\n" + "in the farmyard !";
    private String fichePilote11EN = "Don't reach out to him,\n" + " unless you no longer\n" +
            " need it !";
    private String fichePilote12EN = "A big plush toy\n" + "that slams !";

    private String ficheVehicule1EN = "We hadn't been cheaper !";
    private String ficheVehicule2EN = "It may surprise !";
    private String ficheVehicule3EN = "The ardour of youth !";
    private String ficheVehicule4EN = "The most nervous\n" + "of the circuit !";
    private String ficheVehicule5EN= "Luxurious... and muddy...";
    private String ficheVehicule6EN = "Explode your enemies\n" + "with tact...";
    private String ficheVehicule7EN = "Be wary of elders !";
    private String ficheVehicule8EN = "It dominates the fields !";
    private String ficheVehicule9EN = "Don't just lie\n" + "on your towels !";
    private String ficheVehicule10EN = "Nothing stops him !";
    private String ficheVehicule11EN = "A heavyweight,\n" + "a real one !";
    private String ficheVehicule12EN = "Created to crush !";

    private String ficheCircuit1EN = "Be careful in\n" + "the descent !";
    private String ficheCircuit2EN = "Don't forget\n" + "your water bottle !";
    private String ficheCircuit3EN = "A small step for the\n" + "animal,a big leap for\n" + " the Monster truck";
    private String ficheCircuit4EN = "Pretty creepy...\n" + "especially at night...";
    private String ficheCircuit5EN = "The forest of all\n" + "dangers !";
    private String ficheCircuit6EN = "When heaven\n" + "turns to hell...";
    private String ficheCircuit7EN = "The city is a jungle !";
    private String ficheCircuit8EN = "It's so much better\n" + "in the country...";
    private String ficheCircuit9EN = "Another world,\n" + "kilometres below\n" + "the surface";
    private String ficheCircuit10EN = "Ideal for family\n"+"holidays !";
    private String ficheCircuit11EN = "You have to be a\n" + "penguin to live here !";
    private String ficheCircuit12EN = "Bring your gas mask !";

    private String sauvegarderEN = "SAVE";

    private String boutonMenuGeneralPiloteEN = "DRIVER";
    private String boutonMenuGeneralVehiculeEN = "VEHICLE";
    private String boutonMenuGeneralCircuitEN = "TRAIL";
    private String boutonMenuGeneralBoutiqueEN = "SHOP";
    private String boutonMenuGeneralAtelierEN = "WORKSHOP";

    private String boutonReplayEN = "REPLAY";
    private String boutonResumeEN = "CONTINUE";

    private String panneTimerLabelEN = "you still have ";
    private String secondesEN = " seconds";
    private String readyEN = "READY ?";

    private String tropheeEN = " award";

    private String manqueArgentEN = "you need to have";

    private String timerDecompteEN = "     you've watched \n"+"   10 videos in 2 hours,\n"+"    you have to wait";

    private String ficheComptePart1EN = "Money : ";
    private String ficheComptePart2EN = "( maximum amount earned during a game )";
    private String ficheComptePart3EN = "Number of Wheel Trophee : ";
    private String ficheComptePart4EN = "( Trophy record obtained by crushing a maximum number of vehicles )";
    private String ficheComptePart5EN = "Number of Trophee Dollar : ";
    private String ficheComptePart6EN = "( Trophy record obtained by winning more than 3500 $ during a game )";
    private String ficheComptePart7EN = "";
    private String ficheComptePart8EN = "Nombre of Trophee Bonus : ";
    private String ficheComptePart9EN = "( Trophy record obtained by collecting bonuses : ";
    private String ficheComptePart10EN = " free diesel fuel, $100 ticket and nitro )";
    private String ficheComptePart11EN = "Max money : ";

    private String popUpWifiLabelPart1EN = "   you must be";
    private String popUpWifiLabelPart2EN = " connected via";
    private String popUpWifiLabelPart3EN = " wifi to watch";
    private String popUpWifiLabelPart4EN = "        videos";

    // ES
    private String fichePilote1ES = "Se desliza sobre los \n" + "pecios como las olas !";
    private String fichePilote2ES = "Se las va a comer\n" + "todas crudas !";
    private String fichePilote3ES = "Una trituradora \n" + "prehistorica de 7\n" + "toneladas !";
    private String fichePilote4ES = "La motocicleta de los\n" + " caballeros...";
    private String fichePilote5ES = "El nieto de los \n" + "...Triceratops menos\n"+" 1 cuerno !";
    private String fichePilote6ES = "En un dos por ciento,\n" + "teníamos el mismo ADN !";
    private String fichePilote7ES = "Lenta pero segura,\n" + "ahorra tiempo...";
    private String fichePilote8ES = "El símbolo de todos\n" + "los rockeros !";
    private String fichePilote9ES = "Ningun pajaro puede\n" + "resistir su encanto";
    private String fichePilote10ES = "Mantiene el orden\n" + "en el corral !";
    private String fichePilote11ES = "No te acerques a el a\n" + "menos que ya no lo\n"+" necesites !";
    private String fichePilote12ES = "Un gran juguete de\n" + "peluche que golpea !";

    private String ficheVehicule1ES = "No habíamos sido mas\n" + " baratos !";
    private String ficheVehicule2ES = "Puede sorprender !";
    private String ficheVehicule3ES = "El ardor de la juventud !";
    private String ficheVehicule4ES = "Los mas nerviosos\n" + "del circuito !";
    private String ficheVehicule5ES= "Lujoso... y fangoso...";
    private String ficheVehicule6ES = "Con tacto hace\n" + "explotar a sus enemigos";
    private String ficheVehicule7ES = "Desconfíe de\n"+" los ancianos !";
    private String ficheVehicule8ES = "Domina los campos !";
    private String ficheVehicule9ES = "No te tumbes sobre\n" + "tus toallas !";
    private String ficheVehicule10ES = "Nada lo detiene !";
    private String ficheVehicule11ES = "Un peso pesado,\n"+" uno real !";
    private String ficheVehicule12ES = "Creado para aplastar !";

    private String ficheCircuit1ES = "Cuidado en el descenso !";
    private String ficheCircuit2ES = "No olvides tu botella de\n" + "agua !";
    private String ficheCircuit3ES = "Un pequeno paso para el\n" + "animal, un gran salto\n" + "para el Monster truck";
    private String ficheCircuit4ES = "Bastante aterrador...\n" + "sobre todo por la noche...";
    private String ficheCircuit5ES = "El bosque de todos los\n" + "peligros !";
    private String ficheCircuit6ES = "Cuando el cielo se\n" + "convierte en infierno...";
    private String ficheCircuit7ES = "La ciudad es una jungla !";
    private String ficheCircuit8ES = "Es mucho mejor en el\n" + "campo...";
    private String ficheCircuit9ES = "Otro mundo,\n" + "kilometros por debajo\n" + "de la superficie";
    private String ficheCircuit10ES = "Ideal para vacaciones\n" + "en familia !";
    private String ficheCircuit11ES = "Tienes que ser un\n" + "pinguino para vivir aqui";
    private String ficheCircuit12ES = "Traiga su mascara\n" + "antigas !";

    private String sauvegarderES = "AHORRAR";

    private String boutonMenuGeneralPiloteES = "PILOTO";
    private String boutonMenuGeneralVehiculeES = "COCHE";
    private String boutonMenuGeneralCircuitES = "TRAYECTO";
    private String boutonMenuGeneralBoutiqueES = "NEGOCIO";
    private String boutonMenuGeneralAtelierES = "TALLER";

    private String boutonReplayES = "REEDICION";
    private String boutonResumeES = "CONTINUAR";

    private String panneTimerLabelES = "todavia te queda ";
    private String secondesES = " segundos";
    private String readyES = "LISTO ?";

    private String tropheeES = " trofeo";

    private String manqueArgentES = "usted necesita";

    private String timerDecompteES = "          has visto \n"+"   10 videos en 2 horas,\n"+"   tienes que esperar";

    private String ficheComptePart1ES = "Dinero : ";
    private String ficheComptePart2ES = "( cantidad maxima ganada durante un juego )";
    private String ficheComptePart3ES = "Numero de trofeo de rueda : ";
    private String ficheComptePart4ES = "( Record de trofeos obtenido por aplastamiento de un max de vehiculos )";
    private String ficheComptePart5ES = "Numero de trofeo Dollar : ";
    private String ficheComptePart6ES = "( Record de trofeos obtenido al ganar más de 3500 $ ";
    private String ficheComptePart7ES = " durante un partido )";
    private String ficheComptePart8ES = "Numero de trofeo Bonus : ";
    private String ficheComptePart9ES = "( Registro de trofeos obtenidos por el cobro de bonus : ";
    private String ficheComptePart10ES = " diesel gratis, billete de $100 y nitro )";
    private String ficheComptePart11ES = "Dinero maximo : ";

    private String popUpWifiLabelPart1ES = "   debes estar";
    private String popUpWifiLabelPart2ES = " conectado via";
    private String popUpWifiLabelPart3ES = "     wifi para";
    private String popUpWifiLabelPart4ES = "    ver videos";

    // DE
    private String fichePilote1DE = "Es rutscht auf Wracks\n" + "wie Wellen !";
    private String fichePilote2DE = "Er wird sie alle\n" + "roh essen !";
    private String fichePilote3DE = "Ein prahistorischer\n" + "7-Tonnen-Brecher !";
    private String fichePilote4DE = "Das Motorrad der\n"+"Ritter...";
    private String fichePilote5DE = "Der Enkel der\n" + "Triceratops... minus\n"+" 1 Horn !";
    private String fichePilote6DE = "Innerhalb von zwei \n" + "Prozent hatten wir \n" + "die gleiche DNA !";
    private String fichePilote7DE = "Langsam, aber sicher\n" + "spart sie Zeit...";
    private String fichePilote8DE = "Das Symbol aller\n" + "Wippen !";
    private String fichePilote9DE = "Kein Vogel kann seinem\n" + "Charme widerstehen";
    private String fichePilote10DE = "Er sorgt fur Ordnung\n" + "auf dem Hof !";
    private String fichePilote11DE = "Erreiche ihn nicht,\n" + "es sei denn, du brauchst\n" + "ihn nicht mehr !";
    private String fichePilote12DE = "Ein riesiges\n" + "Pluschspielzeug das ihr\n" + "Gesicht zuschlagt !";

    private String ficheVehicule1DE = "Wir waren nicht billiger\n" + "gewesen !";
    private String ficheVehicule2DE = "Es mag uberraschen !";
    private String ficheVehicule3DE = "Die Begeisterung der\n" + "Jugend !";
    private String ficheVehicule4DE = "Der Nervoseste\n" + "der Gruppe !";
    private String ficheVehicule5DE= "Luxurios....\n"+"und schlammig...";
    private String ficheVehicule6DE = "Explodiert taktvoll\n" + "seine Feinde...";
    private String ficheVehicule7DE = "Seid vorsichtig mit den\n" + "Altesten !";
    private String ficheVehicule8DE = "Es dominiert die Felder !";
    private String ficheVehicule9DE = "Leg dich nicht nur auf\n" + "deine Handtucher !";
    private String ficheVehicule10DE = "Nichts halt ihn auf !";
    private String ficheVehicule11DE = "Ein Schwergewicht, \n" + "ein echtes !";
    private String ficheVehicule12DE = "Erstellt, um zu \n" + "zerkleinern !";

    private String ficheCircuit1DE = "Seien Sie vorsichtig\n" + "beim Abstieg !";
    private String ficheCircuit2DE = "Vergiss deine\n" + "Trinkflasche nicht !";
    private String ficheCircuit3DE = "Ein kleiner Schritt fur\n" + "das ein grosser Sprung\n" + "fur den Monstertruck";
    private String ficheCircuit4DE = "Ziemlich gruselig...\n" + "besonders nachts...";
    private String ficheCircuit5DE = "Der Wald aller\n" + "Gefahren !";
    private String ficheCircuit6DE = "Wenn der Himmel\n" + "zur Hölle wird...";
    private String ficheCircuit7DE = "Die Stadt ist ein\n" + "Dschungel !";
    private String ficheCircuit8DE = "Es ist so viel besser\n" + "besser auf dem Land...";
    private String ficheCircuit9DE = "Eine andere Welt, \n" + "Kilometer unter der\n" + "Oberflache";
    private String ficheCircuit10DE = "Ideal für Familienferien !";
    private String ficheCircuit11DE = "Man muss ein Pinguin\n" + "sein, um hier zu leben !";
    private String ficheCircuit12DE = "Bringen Sie Ihre\n" + "Gasmaske mit !";

    private String sauvegarderDE = "SPEICHERN";

    private String boutonMenuGeneralPiloteDE = "FARHER";
    private String boutonMenuGeneralVehiculeDE = "VEHIKEL";
    private String boutonMenuGeneralCircuitDE = "SCHALTKREIS";
    private String boutonMenuGeneralBoutiqueDE = "WERKSTATT";
    private String boutonMenuGeneralAtelierDE = "WORKSHOP";

    private String boutonReplayDE = "WIEDERHOLUNG";
    private String boutonResumeDE = "WEITERMACHEN";

    private String panneTimerLabelDE = "Du hast noch ";
    private String secondesDE = " Sekunden";
    private String readyDE = "BEREIT ?";

    private String tropheeDE = " Trophee";

    private String manqueArgentDE = "    du musst";

    private String timerDecompteDE = "     Du hast 10 Videos\n"+"  in 2 Stunden gesehen,\n"+"     du musst warten";

    private String ficheComptePart1DE = "Geld : ";
    private String ficheComptePart2DE = "( maximaler Betrag, der während eines Spiels verdient wurde )";
    private String ficheComptePart3DE = "Anzahl der Rad-Tropheen : ";
    private String ficheComptePart4DE = "( Trophäenrekord durch Zerkleinerung einer maximalen Anzahl\n " +"von Fahrzeugen )";
    private String ficheComptePart5DE = "Anzahl der Trophee Dollar : ";
    private String ficheComptePart6DE = "( Trophäenrekord, der durch den Gewinn von mehr als 3500 Punkten\n" +"erzielt wurde $ wahrend eines Spiels )";
    private String ficheComptePart7DE = "";
    private String ficheComptePart8DE = "Anzahl der Trophaenboni : ";
    private String ficheComptePart9DE = "( Trophäe dank der Boni: kostenloser Diesel, 100 $ und Nitro )";
    private String ficheComptePart10DE = "";
    private String ficheComptePart11DE = "Max. Geld : ";


    private String popUpWifiLabelPart1DE = "  Du musst uber WLAN";
    private String popUpWifiLabelPart2DE = "  verbunden sein, um";
    private String popUpWifiLabelPart3DE = "      Videos ansehen";
    private String popUpWifiLabelPart4DE = "           zu konnen";

    // IT
    private String fichePilote1IT = "Scivola come onde sui\n" + "relitti !";
    private String fichePilote2IT = "Li mangera tutti crudi !";
    private String fichePilote3IT = "Un frantoio preistorico\n" + "da 7 tonnellate !";
    private String fichePilote4IT = "La moto dei cavalieri...";
    private String fichePilote5IT = "Il nipote dei Triceratops\n" + "... meno 1 corno !";
    private String fichePilote6IT = "Nel giro del due\n" + "percento, avevamo\n"+"lo stesso DNA !";
    private String fichePilote7IT = "Lentamente, ma\n" + "inesorabilmente, sta\n" + "risparmiando tempo...";
    private String fichePilote8IT = "Il simbolo di tutti i \n" + "rocker !";
    private String fichePilote9IT = "Nessun uccello può\n" + "resistere al suo fascino";
    private String fichePilote10IT = "Tiene l'ordine nell'aia ";
    private String fichePilote11IT = "Non contattarlo, a\n" + "meno che non ne abbiate\n" + "piu bisogno !";
    private String fichePilote12IT = "Un grande peluche che\n" + "sbatte !";

    private String ficheVehicule1IT = "Non siamo stati piu\n" + "economici !";
    private String ficheVehicule2IT = "Potrebbe sorprendere !";
    private String ficheVehicule3IT = "L'ardore della gioventu !";
    private String ficheVehicule4IT = "Il piu nervoso del\n" + "circuito !";
    private String ficheVehicule5IT = "Lussuoso..... e fangoso...";
    private String ficheVehicule6IT = "Esplode con tatto i suoi\n" + "nemici...";
    private String ficheVehicule7IT = "Diffidare degli anziani !";
    private String ficheVehicule8IT = "Domina i campi !";
    private String ficheVehicule9IT = "Non sdraiarti solo\n" + "sugli asciugamani !";
    private String ficheVehicule10IT = "Niente lo ferma !";
    private String ficheVehicule11IT = "Un peso massimo, uno\n" + "vero e proprio !";
    private String ficheVehicule12IT = "Creato per\n"+"schiacciare !";

    private String ficheCircuit1IT = "Fare attenzione in\n" + "discesa !";
    private String ficheCircuit2IT = "Non dimenticare la tua\n" + "bottiglia d'acqua !";
    private String ficheCircuit3IT = "Un piccolo passo per\n" + "l'animale, un grande\n" + "balzo per il\n"+"Monster truck";
    private String ficheCircuit4IT = "Piuttosto inquietante...\n" + "specialmente di notte...";
    private String ficheCircuit5IT = "La foresta di tutti\n" + "i pericoli !";
    private String ficheCircuit6IT = "Quando il cielo si\n" + "trasforma in inferno...";
    private String ficheCircuit7IT = "La citta e una giungla !";
    private String ficheCircuit8IT = "E molto meglio\n" + "in campagna...";
    private String ficheCircuit9IT = "Un altro mondo,\n" + "chilometri sotto\n" + "la superficie";
    private String ficheCircuit10IT = "Ideale per le vacanze in\n" + "famiglia !";
    private String ficheCircuit11IT = "Devi essere un pinguino\n" + "per vivere qui !";
    private String ficheCircuit12IT = "Porta la tua maschera\n" + "antigas !";

    private String sauvegarderIT = "PRIMATO";

    private String boutonMenuGeneralPiloteIT = "PILOTA";
    private String boutonMenuGeneralVehiculeIT = "VEICOLO";
    private String boutonMenuGeneralCircuitIT = "TRAGITTO";
    private String boutonMenuGeneralBoutiqueIT = "BOTTEGA";
    private String boutonMenuGeneralAtelierIT = "OFFICINA";

    private String boutonReplayIT = "REPLAY";
    private String boutonResumeIT = "CONTINUARE";

    private String panneTimerLabelIT = "ti resta ancora ";
    private String secondesIT = " secondi";
    private String readyIT = "PRONTO ?";

    private String tropheeIT = " trofeo";

    private String manqueArgentIT = "  e necessario";

    private String timerDecompteIT = "     hai guardato\n"+"  10 video in 2 ore,\n"+"    devi aspettare";

    private String ficheComptePart1IT = "I soldi : ";
    private String ficheComptePart2IT = "( importo massimo guadagnato durante una partita )";
    private String ficheComptePart3IT = "Numero di trofeo della ruota : ";
    private String ficheComptePart4IT = "( Record di trofeo ottenuto schiacciando un massimo di veicoli )";
    private String ficheComptePart5IT = "Numero di Trophee Dollar : ";
    private String ficheComptePart6IT = "( Record di trofeo ottenuto vincendo più di 3500 $ ";
    private String ficheComptePart7IT = " durante una partita )";
    private String ficheComptePart8IT = "Numero di Trophee Bonus : ";
    private String ficheComptePart9IT = "( Record di trofeo ottenuto raccogliendo i bonus : ";
    private String ficheComptePart10IT = " diesel gratuito, biglietto da 100 dollari e azoto. )";
    private String ficheComptePart11IT = "Soldi massimi : ";

    private String popUpWifiLabelPart1IT = "  è necessario essere";
    private String popUpWifiLabelPart2IT = "    connessi via wifi";
    private String popUpWifiLabelPart3IT = "         per guardare";
    private String popUpWifiLabelPart4IT = "              i video";

    // NL
    private String fichePilote1NL = "Het glijdt als golven op\n" + "wrakken !";
    private String fichePilote2NL = "Hij gaat ze allemaal\n" + "rauw eten !";
    private String fichePilote3NL = "Een prehistorische\n" + "7-tons breker !";
    private String fichePilote4NL = "De motorfiets van de\n" + " ridders...";
    private String fichePilote5NL = "De kleinzoon van de\n" + " Triceratops\n" + "... minus 1 hoorn !";
    private String fichePilote6NL = "Binnen twee procent\n" + "hadden we hetzelfde DNA !";
    private String fichePilote7NL = "Langzaam maar zeker\n" + "bespaart ze tijd...";
    private String fichePilote8NL = "Het symbool van alle\n" + "rockers !";
    private String fichePilote9NL = "Geen enkele vogel kan\n" + "zijn charme weerstaan";
    private String fichePilote10NL = "Hij houdt orde op het\n" + "erf !";
    private String fichePilote11NL = "Streef niet naar hem uit,\n" + "tenzij je het niet langer\n" + "nodig hebt !";
    private String fichePilote12NL = "Een groot pluchen\n" + "speelgoed dat\n"+"dichtslaat !";

    private String ficheVehicule1NL = "We waren niet goedkoper\n" + "geweest !";
    private String ficheVehicule2NL = "Het kan verrassen !";
    private String ficheVehicule3NL = "De ijver van de jeugd !";
    private String ficheVehicule4NL = "De meest nerveuze\n" + "van het circuit !";
    private String ficheVehicule5NL = "Luxe... en modderig...";
    private String ficheVehicule6NL = "Tactvol explodeert zijn\n" + "vijanden...";
    private String ficheVehicule7NL = "Wees op uw hoede voor\n" + "oudsten !";
    private String ficheVehicule8NL = "Het domineert de velden !";
    private String ficheVehicule9NL = "Ga niet alleen op uw\n" + "handdoeken liggen !";
    private String ficheVehicule10NL = "Niets houdt hem tegen !";
    private String ficheVehicule11NL = "Een zwaargewicht, een\n" + "echte !";
    private String ficheVehicule12NL = "Gemaakt om te\n" + "verpletteren !";

    private String ficheCircuit1NL = "Wees voorzichtig in de\n" + "afdaling !";
    private String ficheCircuit2NL = "Vergeet uw\n"+"waterfles niet !";
    private String ficheCircuit3NL = "Een kleine stap voor het\n" + "dier, een grote sprong\n" + "voor de Monster truck";
    private String ficheCircuit4NL = "Vrij griezelig...\n" + "vooral 's nachts...";
    private String ficheCircuit5NL = "Het bos van alle\n"+"gevaren !";
    private String ficheCircuit6NL = "Wanneer de hemel zich\n" + "tot de hel wendt...";
    private String ficheCircuit7NL = "De stad is een jungle !";
    private String ficheCircuit8NL = "Het is zo veel beter in\n" + "het land...";
    private String ficheCircuit9NL = "Een andere wereld,\n" + "kilometers onder\n" + "de oppervlakte";
    private String ficheCircuit10NL = "Ideaal voor\n" + "familievakanties !";
    private String ficheCircuit11NL = "Je moet een pinguïn zijn\n" + "om hier te kunnen\n"+"wonen !";
    private String ficheCircuit12NL = "Breng uw gasmasker\n"+"mee !";

    private String sauvegarderNL = "AANTEKENING";

    private String boutonMenuGeneralPiloteNL = "PILOOT";
    private String boutonMenuGeneralVehiculeNL = "VOERTUIG";
    private String boutonMenuGeneralCircuitNL = "CIRCUIT";
    private String boutonMenuGeneralBoutiqueNL = "WINKEL";
    private String boutonMenuGeneralAtelierNL = "WERKPLAATS";

    private String boutonReplayNL = "OVERSPELEN";
    private String boutonResumeNL = "VOORTGAAN";

    private String panneTimerLabelNL = "moet je nog steeds ";
    private String secondesNL = " seconden";
    private String readyNL = "KLAAR ?";

    private String tropheeNL = " Trophee";

    private String manqueArgentNL = "      moet u";

    private String timerDecompteNL = "  je hebt 10 video's\n"+"   bekeken in 2 uur,\n"+"   je moet wachten";

    private String ficheComptePart1NL = "Geld : ";
    private String ficheComptePart2NL = "( maximaal verdiend bedrag tijdens een wedstrijd )";
    private String ficheComptePart3NL = "Aantal wieltrofeeën : ";
    private String ficheComptePart4NL = "( Trofeeenverslag verkregen door het verpletteren van " + "\n" +"een maximaal aantal voertuigen )";
    private String ficheComptePart5NL = "Aantal Trophee Dollar : ";
    private String ficheComptePart6NL = "( Trofeeënverslag verkregen door het winnen van meer dan";
    private String ficheComptePart7NL = " 3500 $ tijdens een wedstrijd )";
    private String ficheComptePart8NL = "Aantal trofeeenbonussen : ";
    private String ficheComptePart9NL = "( gratis diesel, $100 en nitro bonus trofee )";
    private String ficheComptePart10NL = "";
    private String ficheComptePart11NL = "Max. geld : ";

    private String popUpWifiLabelPart1NL = "  u moet verbonden";
    private String popUpWifiLabelPart2NL = "     zijn via wifi";
    private String popUpWifiLabelPart3NL = "        om video's";
    private String popUpWifiLabelPart4NL = "       te bekijken";

    // PL
    private String fichePilote1PL = "Slizga sie po wrakach\n" + "jak fale !";
    private String fichePilote2PL = "On bedzie jesc je\n" + "wszystkie surowe !";
    private String fichePilote3PL = "Prehistoryczna\n" + "kruszarka o masie\n"+"7 ton !";
    private String fichePilote4PL = "Motocykl rycerski...";
    private String fichePilote5PL = "Wnuk Triceratops\n" + "... minus 1 rog !";
    private String fichePilote6PL = "W ciagu dwoch procent,\n" + "mielismy ten sam DNA !";
    private String fichePilote7PL = "Powoli, ale z pewnoscia\n" + "oszczadza czas...";
    private String fichePilote8PL = "Symbol wszystkich\n" + "rockerow !";
    private String fichePilote9PL = "Zaden ptak nie moze\n" + "oprzec sie swojemu\n"+"urokowi";
    private String fichePilote10PL = "Utrzymuje porzadek\n" + "dna podworzu !";
    private String fichePilote11PL = "Nie siegaj do niego,\n" + "chyba ze juz go nie \n" + "potrzebujesz !";
    private String fichePilote12PL = "Duza pluszowa zabawka\n" + "ktora uderza !";

    private String ficheVehicule1PL = "Nie bylismy tansi !";
    private String ficheVehicule2PL = "To moze zaskoczyc !";
    private String ficheVehicule3PL = "Zapal mlodziezy !";
    private String ficheVehicule4PL = "Najbardziej nerwowy\n" + "z obwodow !";
    private String ficheVehicule5PL = "Luksusowe... i blotniste...";
    private String ficheVehicule6PL = "Taktycznie eksploduje\n" + "swoich wrogow...";
    private String ficheVehicule7PL = "Badz ostrozny wobec\n" + "starszych !";
    private String ficheVehicule8PL = "Dominuje na polach !";
    private String ficheVehicule9PL = "Nie kladz sie tylko\n" + "na recznikach !";
    private String ficheVehicule10PL = "Nic go nie zatrzymuje !";
    private String ficheVehicule11PL = "Ciezka, prawdziwa !";
    private String ficheVehicule12PL = "Stworzony do\n"+"zgniecenia !";

    private String ficheCircuit1PL = "Zachowaj ostroznosc\n" + "w zejsciu !";
    private String ficheCircuit2PL = "Nie zapomnij o butelce\n" + "z woda !";
    private String ficheCircuit3PL = "Maly krok dla\n" + "zwierzecia, duzy skok\n" + "dla Monster truck";
    private String ficheCircuit4PL = "Ladnie przerazajace...\n" + "zwlaszcza w nocy...";
    private String ficheCircuit5PL = "Las wszystkich\n" + "niebezpieczenstw !";
    private String ficheCircuit6PL = "Kiedy niebo zamienia\n" + "sie w pieklo...";
    private String ficheCircuit7PL = "Miasto jest dzungla !";
    private String ficheCircuit8PL = "W kraju jest o wiele\n" + "lepiej...";
    private String ficheCircuit9PL = "Kolejny swiat, kilometr\n" + "pod powierzchnia";
    private String ficheCircuit10PL = "Idealny na rodzinne\n" + "wakacje !";
    private String ficheCircuit11PL = "Musisz byc pingwinem,\n" + "aby tu mieszkac !";
    private String ficheCircuit12PL = "Przynies maske\n" + "przeciwgazowa !";

    private String sauvegarderPL = "NAGRANIOWY";

    private String boutonMenuGeneralPilotePL = "PILOT";
    private String boutonMenuGeneralVehiculePL = "POJAZD";
    private String boutonMenuGeneralCircuitPL = "OBWODY";
    private String boutonMenuGeneralBoutiquePL = "SKLEPIK";
    private String boutonMenuGeneralAtelierPL = "WARSZTAT";

    private String boutonReplayPL = "POWTORKA";
    private String boutonResumePL = "KONTYNUOWAC";

    private String panneTimerLabelPL = "nadal musisz ";
    private String secondesPL = " sekund";
    private String readyPL = "GOTOWY ?";

    private String tropheePL = " trofeum";

    private String manqueArgentPL = "     musisz";

    private String timerDecomptePL = " obejrzales 10 filmow\n"+"    w ciagu 2 godzin,\n"+"    musisz poczekac";

    private String ficheComptePart1PL = "Pieniadze : ";
    private String ficheComptePart2PL = "( maksymalna kwota zarobiona podczas gry )";
    private String ficheComptePart3PL = "Liczba wnek kol : ";
    private String ficheComptePart4PL = "( Rekord trofeum uzyskany przez zmiazdzenie maksymalnej liczby pojazdów )";
    private String ficheComptePart5PL = "Liczba dolara tropikalnego : ";
    private String ficheComptePart6PL = "( Rekord trofeum uzyskany poprzez wygrana ponad 3500 $ ";
    private String ficheComptePart7PL = " podczas gry )";
    private String ficheComptePart8PL = "Liczba premii tropikalnych : ";
    private String ficheComptePart9PL = "( Rekord trofeum : bezplatny olej napedowy, bilet w cenie 100 USD i nitro )";
    private String ficheComptePart10PL = "";
    private String ficheComptePart11PL = "Maks. ilosc pieniędzy : ";


    private String popUpWifiLabelPart1PL = "      musisz byc";
    private String popUpWifiLabelPart2PL = " polaczony przez";
    private String popUpWifiLabelPart3PL = "       Wifi, aby";
    private String popUpWifiLabelPart4PL = "   oglądać filmy";

    public Translator() {
        if(Locale.getDefault().getLanguage().equals("fr")){
            fichePilote1 = fichePilote1FR;
            fichePilote2 = fichePilote2FR;
            fichePilote3 = fichePilote3FR;
            fichePilote4 = fichePilote4FR;
            fichePilote5 = fichePilote5FR;
            fichePilote6 = fichePilote6FR;
            fichePilote7 = fichePilote7FR;
            fichePilote8 = fichePilote8FR;
            fichePilote9 = fichePilote9FR;
            fichePilote10 = fichePilote10FR;
            fichePilote11 = fichePilote11FR;
            fichePilote12 = fichePilote12FR;

            ficheVehicule1 = ficheVehicule1FR;
            ficheVehicule2 = ficheVehicule2FR;
            ficheVehicule3 = ficheVehicule3FR;
            ficheVehicule4 = ficheVehicule4FR;
            ficheVehicule5 = ficheVehicule5FR;
            ficheVehicule6 = ficheVehicule6FR;
            ficheVehicule7 = ficheVehicule7FR;
            ficheVehicule8 = ficheVehicule8FR;
            ficheVehicule9 = ficheVehicule9FR;
            ficheVehicule10 = ficheVehicule10FR;
            ficheVehicule11 = ficheVehicule11FR;
            ficheVehicule12 = ficheVehicule12FR;

            ficheCircuit1 = ficheCircuit1FR;
            ficheCircuit2 = ficheCircuit2FR;
            ficheCircuit3 = ficheCircuit3FR;
            ficheCircuit4 = ficheCircuit4FR;
            ficheCircuit5 = ficheCircuit5FR;
            ficheCircuit6 = ficheCircuit6FR;
            ficheCircuit7 = ficheCircuit7FR;
            ficheCircuit8 = ficheCircuit8FR;
            ficheCircuit9 = ficheCircuit9FR;
            ficheCircuit10 = ficheCircuit10FR;
            ficheCircuit11 = ficheCircuit11FR;
            ficheCircuit12 = ficheCircuit12FR;

            sauvegarder = sauvegarderFR;

            boutonMenuGeneralPilote = boutonMenuGeneralPiloteFR;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculeFR;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitFR;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiqueFR;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierFR;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayFR;
            boutonResume = boutonResumeFR;

            panneTimerLabel = panneTimerLabelFR;
            secondes = secondesFR;
            ready = readyFR;

            manqueArgent = manqueArgentFR;

            timerDecompte = timerDecompteFR;

            trophee = tropheeFR;

            ficheComptePart1 = ficheComptePart1FR;
            ficheComptePart2 = ficheComptePart2FR;
            ficheComptePart3 = ficheComptePart3FR;
            ficheComptePart4 = ficheComptePart4FR;
            ficheComptePart5 = ficheComptePart5FR;
            ficheComptePart6 = ficheComptePart6FR;
            ficheComptePart7 = ficheComptePart7FR;
            ficheComptePart8 = ficheComptePart8FR;
            ficheComptePart9 = ficheComptePart9FR;
            ficheComptePart10 = ficheComptePart10FR;
            ficheComptePart11 = ficheComptePart11FR;

            popUpWifiLabelPart1 = popUpWifiLabelPart1FR;
            popUpWifiLabelPart2 = popUpWifiLabelPart2FR;
            popUpWifiLabelPart3 = popUpWifiLabelPart3FR;
            popUpWifiLabelPart4 = popUpWifiLabelPart4FR;
        }
        if(Locale.getDefault().getLanguage().equals("es")){
            fichePilote1 = fichePilote1ES;
            fichePilote2 = fichePilote2ES;
            fichePilote3 = fichePilote3ES;
            fichePilote4 = fichePilote4ES;
            fichePilote5 = fichePilote5ES;
            fichePilote6 = fichePilote6ES;
            fichePilote7 = fichePilote7ES;
            fichePilote8 = fichePilote8ES;
            fichePilote9 = fichePilote9ES;
            fichePilote10 = fichePilote10ES;
            fichePilote11 = fichePilote11ES;
            fichePilote12 = fichePilote12ES;

            ficheVehicule1 = ficheVehicule1ES;
            ficheVehicule2 = ficheVehicule2ES;
            ficheVehicule3 = ficheVehicule3ES;
            ficheVehicule4 = ficheVehicule4ES;
            ficheVehicule5 = ficheVehicule5ES;
            ficheVehicule6 = ficheVehicule6ES;
            ficheVehicule7 = ficheVehicule7ES;
            ficheVehicule8 = ficheVehicule8ES;
            ficheVehicule9 = ficheVehicule9ES;
            ficheVehicule10 = ficheVehicule10ES;
            ficheVehicule11 = ficheVehicule11ES;
            ficheVehicule12 = ficheVehicule12ES;

            ficheCircuit1 = ficheCircuit1ES;
            ficheCircuit2 = ficheCircuit2ES;
            ficheCircuit3 = ficheCircuit3ES;
            ficheCircuit4 = ficheCircuit4ES;
            ficheCircuit5 = ficheCircuit5ES;
            ficheCircuit6 = ficheCircuit6ES;
            ficheCircuit7 = ficheCircuit7ES;
            ficheCircuit8 = ficheCircuit8ES;
            ficheCircuit9 = ficheCircuit9ES;
            ficheCircuit10 = ficheCircuit10ES;
            ficheCircuit11 = ficheCircuit11ES;
            ficheCircuit12 = ficheCircuit12ES;

            sauvegarder = sauvegarderES;

            boutonMenuGeneralPilote = boutonMenuGeneralPiloteES;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculeES;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitES;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiqueES;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierES;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayES;
            boutonResume = boutonResumeES;

            panneTimerLabel = panneTimerLabelES;
            secondes = secondesES;
            ready = readyES;

            trophee = tropheeES;

            manqueArgent = manqueArgentES;

            timerDecompte = timerDecompteES;

            ficheComptePart1 = ficheComptePart1ES;
            ficheComptePart2 = ficheComptePart2ES;
            ficheComptePart3 = ficheComptePart3ES;
            ficheComptePart4 = ficheComptePart4ES;
            ficheComptePart5 = ficheComptePart5ES;
            ficheComptePart6 = ficheComptePart6ES;
            ficheComptePart7 = ficheComptePart7ES;
            ficheComptePart8 = ficheComptePart8ES;
            ficheComptePart9 = ficheComptePart9ES;
            ficheComptePart10 = ficheComptePart10ES;
            ficheComptePart11 = ficheComptePart11ES;

            popUpWifiLabelPart1 = popUpWifiLabelPart1ES;
            popUpWifiLabelPart2 = popUpWifiLabelPart2ES;
            popUpWifiLabelPart3 = popUpWifiLabelPart3ES;
            popUpWifiLabelPart4 = popUpWifiLabelPart4ES;
        }
        if(Locale.getDefault().getLanguage().equals("de")){
            fichePilote1 = fichePilote1DE;
            fichePilote2 = fichePilote2DE;
            fichePilote3 = fichePilote3DE;
            fichePilote4 = fichePilote4DE;
            fichePilote5 = fichePilote5DE;
            fichePilote6 = fichePilote6DE;
            fichePilote7 = fichePilote7DE;
            fichePilote8 = fichePilote8DE;
            fichePilote9 = fichePilote9DE;
            fichePilote10 = fichePilote10DE;
            fichePilote11 = fichePilote11DE;
            fichePilote12 = fichePilote12DE;

            ficheVehicule1 = ficheVehicule1DE;
            ficheVehicule2 = ficheVehicule2DE;
            ficheVehicule3 = ficheVehicule3DE;
            ficheVehicule4 = ficheVehicule4DE;
            ficheVehicule5 = ficheVehicule5DE;
            ficheVehicule6 = ficheVehicule6DE;
            ficheVehicule7 = ficheVehicule7DE;
            ficheVehicule8 = ficheVehicule8DE;
            ficheVehicule9 = ficheVehicule9DE;
            ficheVehicule10 = ficheVehicule10DE;
            ficheVehicule11 = ficheVehicule11DE;
            ficheVehicule12 = ficheVehicule12DE;

            ficheCircuit1 = ficheCircuit1DE;
            ficheCircuit2 = ficheCircuit2DE;
            ficheCircuit3 = ficheCircuit3DE;
            ficheCircuit4 = ficheCircuit4DE;
            ficheCircuit5 = ficheCircuit5DE;
            ficheCircuit6 = ficheCircuit6DE;
            ficheCircuit7 = ficheCircuit7DE;
            ficheCircuit8 = ficheCircuit8DE;
            ficheCircuit9 = ficheCircuit9DE;
            ficheCircuit10 = ficheCircuit10DE;
            ficheCircuit11 = ficheCircuit11DE;
            ficheCircuit12 = ficheCircuit12DE;

            sauvegarder = sauvegarderDE;

            boutonMenuGeneralPilote = boutonMenuGeneralPiloteDE;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculeDE;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitDE;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiqueDE;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierDE;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayDE;
            boutonResume = boutonResumeDE;

            panneTimerLabel = panneTimerLabelDE;
            secondes = secondesDE;
            ready = readyDE;

            trophee = tropheeDE;

            manqueArgent = manqueArgentDE;

            timerDecompte = timerDecompteDE;

            ficheComptePart1 = ficheComptePart1DE;
            ficheComptePart2 = ficheComptePart2DE;
            ficheComptePart3 = ficheComptePart3DE;
            ficheComptePart4 = ficheComptePart4DE;
            ficheComptePart5 = ficheComptePart5DE;
            ficheComptePart6 = ficheComptePart6DE;
            ficheComptePart7 = ficheComptePart7DE;
            ficheComptePart8 = ficheComptePart8DE;
            ficheComptePart9 = ficheComptePart9DE;
            ficheComptePart10 = ficheComptePart10DE;
            ficheComptePart11 = ficheComptePart11DE;

            popUpWifiLabelPart1 = popUpWifiLabelPart1DE;
            popUpWifiLabelPart2 = popUpWifiLabelPart2DE;
            popUpWifiLabelPart3 = popUpWifiLabelPart3DE;
            popUpWifiLabelPart4 = popUpWifiLabelPart4DE;
        }
        if(Locale.getDefault().getLanguage().equals("it")){
            fichePilote1 = fichePilote1IT;
            fichePilote2 = fichePilote2IT;
            fichePilote3 = fichePilote3IT;
            fichePilote4 = fichePilote4IT;
            fichePilote5 = fichePilote5IT;
            fichePilote6 = fichePilote6IT;
            fichePilote7 = fichePilote7IT;
            fichePilote8 = fichePilote8IT;
            fichePilote9 = fichePilote9IT;
            fichePilote10 = fichePilote10IT;
            fichePilote11 = fichePilote11IT;
            fichePilote12 = fichePilote12IT;

            ficheVehicule1 = ficheVehicule1IT;
            ficheVehicule2 = ficheVehicule2IT;
            ficheVehicule3 = ficheVehicule3IT;
            ficheVehicule4 = ficheVehicule4IT;
            ficheVehicule5 = ficheVehicule5IT;
            ficheVehicule6 = ficheVehicule6IT;
            ficheVehicule7 = ficheVehicule7IT;
            ficheVehicule8 = ficheVehicule8IT;
            ficheVehicule9 = ficheVehicule9IT;
            ficheVehicule10 = ficheVehicule10IT;
            ficheVehicule11 = ficheVehicule11IT;
            ficheVehicule12 = ficheVehicule12IT;

            ficheCircuit1 = ficheCircuit1IT;
            ficheCircuit2 = ficheCircuit2IT;
            ficheCircuit3 = ficheCircuit3IT;
            ficheCircuit4 = ficheCircuit4IT;
            ficheCircuit5 = ficheCircuit5IT;
            ficheCircuit6 = ficheCircuit6IT;
            ficheCircuit7 = ficheCircuit7IT;
            ficheCircuit8 = ficheCircuit8IT;
            ficheCircuit9 = ficheCircuit9IT;
            ficheCircuit10 = ficheCircuit10IT;
            ficheCircuit11 = ficheCircuit11IT;
            ficheCircuit12 = ficheCircuit12IT;

            sauvegarder = sauvegarderIT;

            boutonMenuGeneralPilote = boutonMenuGeneralPiloteIT;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculeIT;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitIT;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiqueIT;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierIT;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayIT;
            boutonResume = boutonResumeIT;

            panneTimerLabel = panneTimerLabelIT;
            secondes = secondesIT;
            ready = readyIT;

            trophee = tropheeIT;

            manqueArgent = manqueArgentIT;

            timerDecompte = timerDecompteIT;

            ficheComptePart1 = ficheComptePart1IT;
            ficheComptePart2 = ficheComptePart2IT;
            ficheComptePart3 = ficheComptePart3IT;
            ficheComptePart4 = ficheComptePart4IT;
            ficheComptePart5 = ficheComptePart5IT;
            ficheComptePart6 = ficheComptePart6IT;
            ficheComptePart7 = ficheComptePart7IT;
            ficheComptePart8 = ficheComptePart8IT;
            ficheComptePart9 = ficheComptePart9IT;
            ficheComptePart10 = ficheComptePart10IT;
            ficheComptePart11 = ficheComptePart11IT;

            popUpWifiLabelPart1 = popUpWifiLabelPart1IT;
            popUpWifiLabelPart2 = popUpWifiLabelPart2IT;
            popUpWifiLabelPart3 = popUpWifiLabelPart3IT;
            popUpWifiLabelPart4 = popUpWifiLabelPart4IT;
        }
        if(Locale.getDefault().getLanguage().equals("nl")){
            fichePilote1 = fichePilote1NL;
            fichePilote2 = fichePilote2NL;
            fichePilote3 = fichePilote3NL;
            fichePilote4 = fichePilote4NL;
            fichePilote5 = fichePilote5NL;
            fichePilote6 = fichePilote6NL;
            fichePilote7 = fichePilote7NL;
            fichePilote8 = fichePilote8NL;
            fichePilote9 = fichePilote9NL;
            fichePilote10 = fichePilote10NL;
            fichePilote11 = fichePilote11NL;
            fichePilote12 = fichePilote12NL;

            ficheVehicule1 = ficheVehicule1NL;
            ficheVehicule2 = ficheVehicule2NL;
            ficheVehicule3 = ficheVehicule3NL;
            ficheVehicule4 = ficheVehicule4NL;
            ficheVehicule5 = ficheVehicule5NL;
            ficheVehicule6 = ficheVehicule6NL;
            ficheVehicule7 = ficheVehicule7NL;
            ficheVehicule8 = ficheVehicule8NL;
            ficheVehicule9 = ficheVehicule9NL;
            ficheVehicule10 = ficheVehicule10NL;
            ficheVehicule11 = ficheVehicule11NL;
            ficheVehicule12 = ficheVehicule12NL;

            ficheCircuit1 = ficheCircuit1NL;
            ficheCircuit2 = ficheCircuit2NL;
            ficheCircuit3 = ficheCircuit3NL;
            ficheCircuit4 = ficheCircuit4NL;
            ficheCircuit5 = ficheCircuit5NL;
            ficheCircuit6 = ficheCircuit6NL;
            ficheCircuit7 = ficheCircuit7NL;
            ficheCircuit8 = ficheCircuit8NL;
            ficheCircuit9 = ficheCircuit9NL;
            ficheCircuit10 = ficheCircuit10NL;
            ficheCircuit11 = ficheCircuit11NL;
            ficheCircuit12 = ficheCircuit12NL;

            sauvegarder = sauvegarderNL;

            boutonMenuGeneralPilote = boutonMenuGeneralPiloteNL;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculeNL;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitNL;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiqueNL;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierNL;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayNL;
            boutonResume = boutonResumeNL;

            panneTimerLabel = panneTimerLabelNL;
            secondes = secondesNL;
            ready = readyNL;

            trophee = tropheeNL;

            manqueArgent = manqueArgentNL;

            timerDecompte = timerDecompteNL;

            ficheComptePart1 = ficheComptePart1NL;
            ficheComptePart2 = ficheComptePart2NL;
            ficheComptePart3 = ficheComptePart3NL;
            ficheComptePart4 = ficheComptePart4NL;
            ficheComptePart5 = ficheComptePart5NL;
            ficheComptePart6 = ficheComptePart6NL;
            ficheComptePart7 = ficheComptePart7NL;
            ficheComptePart8 = ficheComptePart8NL;
            ficheComptePart9 = ficheComptePart9NL;
            ficheComptePart10 = ficheComptePart10NL;
            ficheComptePart11 = ficheComptePart11NL;

            popUpWifiLabelPart1 = popUpWifiLabelPart1NL;
            popUpWifiLabelPart2 = popUpWifiLabelPart2NL;
            popUpWifiLabelPart3 = popUpWifiLabelPart3NL;
            popUpWifiLabelPart4 = popUpWifiLabelPart4NL;
        }
        if(Locale.getDefault().getLanguage().equals("pl")){
            fichePilote1 = fichePilote1PL;
            fichePilote2 = fichePilote2PL;
            fichePilote3 = fichePilote3PL;
            fichePilote4 = fichePilote4PL;
            fichePilote5 = fichePilote5PL;
            fichePilote6 = fichePilote6PL;
            fichePilote7 = fichePilote7PL;
            fichePilote8 = fichePilote8PL;
            fichePilote9 = fichePilote9PL;
            fichePilote10 = fichePilote10PL;
            fichePilote11 = fichePilote11PL;
            fichePilote12 = fichePilote12PL;

            ficheVehicule1 = ficheVehicule1PL;
            ficheVehicule2 = ficheVehicule2PL;
            ficheVehicule3 = ficheVehicule3PL;
            ficheVehicule4 = ficheVehicule4PL;
            ficheVehicule5 = ficheVehicule5PL;
            ficheVehicule6 = ficheVehicule6PL;
            ficheVehicule7 = ficheVehicule7PL;
            ficheVehicule8 = ficheVehicule8PL;
            ficheVehicule9 = ficheVehicule9PL;
            ficheVehicule10 = ficheVehicule10PL;
            ficheVehicule11 = ficheVehicule11PL;
            ficheVehicule12 = ficheVehicule12PL;

            ficheCircuit1 = ficheCircuit1PL;
            ficheCircuit2 = ficheCircuit2PL;
            ficheCircuit3 = ficheCircuit3PL;
            ficheCircuit4 = ficheCircuit4PL;
            ficheCircuit5 = ficheCircuit5PL;
            ficheCircuit6 = ficheCircuit6PL;
            ficheCircuit7 = ficheCircuit7PL;
            ficheCircuit8 = ficheCircuit8PL;
            ficheCircuit9 = ficheCircuit9PL;
            ficheCircuit10 = ficheCircuit10PL;
            ficheCircuit11 = ficheCircuit11PL;
            ficheCircuit12 = ficheCircuit12PL;

            sauvegarder = sauvegarderPL;

            boutonMenuGeneralPilote = boutonMenuGeneralPilotePL;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculePL;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitPL;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiquePL;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierPL;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayPL;
            boutonResume = boutonResumePL;

            panneTimerLabel = panneTimerLabelPL;
            secondes = secondesPL;
            ready = readyPL;

            trophee = tropheePL;

            manqueArgent = manqueArgentPL;

            timerDecompte = timerDecomptePL;

            ficheComptePart1 = ficheComptePart1PL;
            ficheComptePart2 = ficheComptePart2PL;
            ficheComptePart3 = ficheComptePart3PL;
            ficheComptePart4 = ficheComptePart4PL;
            ficheComptePart5 = ficheComptePart5PL;
            ficheComptePart6 = ficheComptePart6PL;
            ficheComptePart7 = ficheComptePart7PL;
            ficheComptePart8 = ficheComptePart8PL;
            ficheComptePart9 = ficheComptePart9PL;
            ficheComptePart10 = ficheComptePart10PL;
            ficheComptePart11 = ficheComptePart11PL;

            popUpWifiLabelPart1 = popUpWifiLabelPart1PL;
            popUpWifiLabelPart2 = popUpWifiLabelPart2PL;
            popUpWifiLabelPart3 = popUpWifiLabelPart3PL;
            popUpWifiLabelPart4 = popUpWifiLabelPart4PL;
        }
        if(!Locale.getDefault().getLanguage().equals("de") &&
                !Locale.getDefault().getLanguage().equals("fr") &&
                !Locale.getDefault().getLanguage().equals("es") &&
                !Locale.getDefault().getLanguage().equals("it") &&
                !Locale.getDefault().getLanguage().equals("nl") &&
                !Locale.getDefault().getLanguage().equals("pl")){
            fichePilote1 = fichePilote1EN;
            fichePilote2 = fichePilote2EN;
            fichePilote3 = fichePilote3EN;
            fichePilote4 = fichePilote4EN;
            fichePilote5 = fichePilote5EN;
            fichePilote6 = fichePilote6EN;
            fichePilote7 = fichePilote7EN;
            fichePilote8 = fichePilote8EN;
            fichePilote9 = fichePilote9EN;
            fichePilote10 = fichePilote10EN;
            fichePilote11 = fichePilote11EN;
            fichePilote12 = fichePilote12EN;

            ficheVehicule1 = ficheVehicule1EN;
            ficheVehicule2 = ficheVehicule2EN;
            ficheVehicule3 = ficheVehicule3EN;
            ficheVehicule4 = ficheVehicule4EN;
            ficheVehicule5 = ficheVehicule5EN;
            ficheVehicule6 = ficheVehicule6EN;
            ficheVehicule7 = ficheVehicule7EN;
            ficheVehicule8 = ficheVehicule8EN;
            ficheVehicule9 = ficheVehicule9EN;
            ficheVehicule10 = ficheVehicule10EN;
            ficheVehicule11 = ficheVehicule11EN;
            ficheVehicule12 = ficheVehicule12EN;

            ficheCircuit1 = ficheCircuit1EN;
            ficheCircuit2 = ficheCircuit2EN;
            ficheCircuit3 = ficheCircuit3EN;
            ficheCircuit4 = ficheCircuit4EN;
            ficheCircuit5 = ficheCircuit5EN;
            ficheCircuit6 = ficheCircuit6EN;
            ficheCircuit7 = ficheCircuit7EN;
            ficheCircuit8 = ficheCircuit8EN;
            ficheCircuit9 = ficheCircuit9EN;
            ficheCircuit10 = ficheCircuit10EN;
            ficheCircuit11 = ficheCircuit11EN;
            ficheCircuit12 = ficheCircuit12EN;

            sauvegarder = sauvegarderEN;

            boutonMenuGeneralPilote = boutonMenuGeneralPiloteEN;
            boutonMenuGeneralVehicule = boutonMenuGeneralVehiculeEN;
            boutonMenuGeneralCircuit = boutonMenuGeneralCircuitEN;
            boutonMenuGeneralBoutique = boutonMenuGeneralBoutiqueEN;
            boutonMenuGeneralAtelier = boutonMenuGeneralAtelierEN;

            boutonMenu = boutonMenuFR;
            boutonReplay = boutonReplayEN;
            boutonResume = boutonResumeEN;

            panneTimerLabel = panneTimerLabelEN;
            secondes = secondesEN;
            ready = readyEN;

            trophee = tropheeEN;

            manqueArgent = manqueArgentEN;

            timerDecompte = timerDecompteEN;

            ficheComptePart1 = ficheComptePart1EN;
            ficheComptePart2 = ficheComptePart2EN;
            ficheComptePart3 = ficheComptePart3EN;
            ficheComptePart4 = ficheComptePart4EN;
            ficheComptePart5 = ficheComptePart5EN;
            ficheComptePart6 = ficheComptePart6EN;
            ficheComptePart7 = ficheComptePart7EN;
            ficheComptePart8 = ficheComptePart8EN;
            ficheComptePart9 = ficheComptePart9EN;
            ficheComptePart10 = ficheComptePart10EN;
            ficheComptePart11 = ficheComptePart11EN;

            popUpWifiLabelPart1 = popUpWifiLabelPart1EN;
            popUpWifiLabelPart2 = popUpWifiLabelPart2EN;
            popUpWifiLabelPart3 = popUpWifiLabelPart3EN;
            popUpWifiLabelPart4 = popUpWifiLabelPart4EN;
        }
    }

    public String getSauvegarder() { return sauvegarder; }

    public String getReady() { return ready; }

    public String getTrophee() { return trophee; }

    public String getPanneTimerLabel() { return panneTimerLabel; }

    public String getSecondes() { return secondes; }

    public String getBoutonMenu() { return boutonMenu; }

    public String getBoutonReplay() { return boutonReplay; }

    public String getBoutonResume() { return boutonResume; }

    public String getBoutonMenuGeneralPilote() { return boutonMenuGeneralPilote; }

    public String getBoutonMenuGeneralVehicule() { return boutonMenuGeneralVehicule; }

    public String getBoutonMenuGeneralCircuit() { return boutonMenuGeneralCircuit; }

    public String getBoutonMenuGeneralBoutique() { return boutonMenuGeneralBoutique; }

    public String getBoutonMenuGeneralAtelier() { return boutonMenuGeneralAtelier; }

    public String getManqueArgent() {
        return manqueArgent;
    }

    public String getTimerDecompte() {
        return timerDecompte;
    }

    public String getFicheComptePart1() {
        return ficheComptePart1;
    }

    public String getFicheComptePart2() {
        return ficheComptePart2;
    }

    public String getFicheComptePart3() {
        return ficheComptePart3;
    }

    public String getFicheComptePart4() {
        return ficheComptePart4;
    }

    public String getFicheComptePart5() {
        return ficheComptePart5;
    }

    public String getFicheComptePart6() {
        return ficheComptePart6;
    }

    public String getFicheComptePart7() {
        return ficheComptePart7;
    }

    public String getFicheComptePart8() {
        return ficheComptePart8;
    }

    public String getFicheComptePart9() {
        return ficheComptePart9;
    }

    public String getFicheComptePart10() {
        return ficheComptePart10;
    }

    public String getFicheComptePart11() {
        return ficheComptePart11;
    }

    public String getPopUpWifiLabelPart1() {
        return popUpWifiLabelPart1;
    }

    public String getPopUpWifiLabelPart2() {
        return popUpWifiLabelPart2;
    }

    public String getPopUpWifiLabelPart3() {
        return popUpWifiLabelPart3;
    }

    public String getPopUpWifiLabelPart4() {
        return popUpWifiLabelPart4;
    }

    public String getFichePilote1() { return fichePilote1; }

    public String getFichePilote2() { return fichePilote2; }

    public String getFichePilote3() { return fichePilote3; }

    public String getFichePilote4() { return fichePilote4; }

    public String getFichePilote5() { return fichePilote5; }

    public String getFichePilote6() { return fichePilote6; }

    public String getFichePilote7() { return fichePilote7; }

    public String getFichePilote8() { return fichePilote8; }

    public String getFichePilote9() { return fichePilote9; }

    public String getFichePilote10() {
        return fichePilote10;
    }

    public String getFichePilote11() {
        return fichePilote11;
    }

    public String getFichePilote12() {
        return fichePilote12;
    }

    public String getFicheVehicule1() {
        return ficheVehicule1;
    }

    public String getFicheVehicule2() {
        return ficheVehicule2;
    }

    public String getFicheVehicule3() {
        return ficheVehicule3;
    }

    public String getFicheVehicule4() {
        return ficheVehicule4;
    }

    public String getFicheVehicule5() {
        return ficheVehicule5;
    }

    public String getFicheVehicule6() {
        return ficheVehicule6;
    }

    public String getFicheVehicule7() {
        return ficheVehicule7;
    }

    public String getFicheVehicule8() {
        return ficheVehicule8;
    }

    public String getFicheVehicule9() {
        return ficheVehicule9;
    }

    public String getFicheVehicule10() {
        return ficheVehicule10;
    }

    public String getFicheVehicule11() {
        return ficheVehicule11;
    }

    public String getFicheVehicule12() {
        return ficheVehicule12;
    }

    public String getFicheCircuit1() {
        return ficheCircuit1;
    }

    public String getFicheCircuit2() {
        return ficheCircuit2;
    }

    public String getFicheCircuit3() {
        return ficheCircuit3;
    }

    public String getFicheCircuit4() {
        return ficheCircuit4;
    }

    public String getFicheCircuit5() {
        return ficheCircuit5;
    }

    public String getFicheCircuit6() {
        return ficheCircuit6;
    }

    public String getFicheCircuit7() {
        return ficheCircuit7;
    }

    public String getFicheCircuit8() {
        return ficheCircuit8;
    }

    public String getFicheCircuit9() {
        return ficheCircuit9;
    }

    public String getFicheCircuit10() {
        return ficheCircuit10;
    }

    public String getFicheCircuit11() {
        return ficheCircuit11;
    }

    public String getFicheCircuit12() {
        return ficheCircuit12;
    }
}
