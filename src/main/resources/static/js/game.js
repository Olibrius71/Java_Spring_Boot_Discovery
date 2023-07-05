import {Card} from "./card.js";

$(document).ready(function() {

    let progessBarTime = 30; // en secondes
    let timeToSeeCards = 2.5; // en secondes

    let nbPairFound = 0;      // nombre de paires trouvées, chiffre de 0 à 12

    $(".game-time-progress-bar").progressbar({
        value: 100,
        classes: {
            "ui-progressbar-value": "ui-corner-all"
        }
    });

    function runProgressBar(pbTime) {

        let intervalUpdate = pbTime * 1000 / 100;

        let progBarTimeRunning = setInterval(() => {
            let currentPbValue = $(".game-time-progress-bar").progressbar("option", "value");

            $(".game-time-progress-bar").progressbar("option", "value", currentPbValue - 1);

            if (currentPbValue == 0) clearInterval(progBarTimeRunning);
        }, intervalUpdate);

    }


    let cardsPaths = [
        "9_of_clubs.png",
        "9_of_diamonds.png",
        "9_of_hearts.png",
        "9_of_spades.png",
        "10_of_clubs.png",
        "10_of_diamonds.png",
        "10_of_hearts.png",
        "10_of_spades.png",
        "jack_of_clubs.png",
        "jack_of_diamonds.png",
        "jack_of_hearts.png",
        "jack_of_spades.png",
        "queen_of_clubs.png",
        "queen_of_diamonds.png",
        "queen_of_hearts.png",
        "queen_of_spades.png",
        "king_of_clubs.png",
        "king_of_diamonds.png",
        "king_of_hearts.png",
        "king_of_spades.png",
        "ace_of_clubs.png",
        "ace_of_diamonds.png",
        "ace_of_hearts.png",
        "ace_of_spades.png",
    ]

    function initCards() {
        let randomOrderCardsPath =  cardsPaths
            .map(value => ({ value, sort: Math.random() }))
            .sort((a, b) => a.sort - b.sort)
            .map(({ value }) => value);   // On crée une liste qui est une version mélangée aléatoire des cartes

        let randomCardsIndex = 0;
        $(".game-card-container > img:last-child").each( function () {
           $(this).attr("src","images/cards/" + randomOrderCardsPath[randomCardsIndex]);
           randomCardsIndex++;
        });
    }


    function hideCard(cardToHide) {    // Ca récupère l'élément HTML de l'image de la carte en question (pas la retournée)
        cardToHide.toggle("puff", 100);
        cardToHide.prev().toggle("puff", 100);
    }

    function showCard(cardToShow) {  // Ca récupérera l'élément HTML de l'image de la carte retournée
        cardToShow.toggle("puff", 100);
        cardToShow.next().next().toggle("puff", 100);
    }

    function hideAllCards() {
        $(".game-card-container > img:last-child").each( function () {
            $(this).toggle("puff", 100);
        });

        setTimeout(() => {
            $(".game-card-container > img:first-child").each(function () {
                $(this).toggle("puff", 100);
            });
        }, 50);
    }


    initCards();

    setTimeout(() => {
        hideAllCards();
        runProgressBar(progessBarTime);
    }, timeToSeeCards * 1000);




    let selectedCard = null;

    $(".game-card-container > img:first-child").click( function () {
        showCard($(this));

        if (selectedCard == null) {
            selectedCard = new Card($(this).attr("src"));
        }
        else {
            let newCard = new Card($(this).attr("src"));
            if (selectedCard.isPair(newCard)) {
                // console.log("eeeeee");
            }
            else {
                // console.log("ffffff");
            }
            selectedCard = null;
        }
    });

    /*
    $(".game-card-container > img:last-child").click( function () {
       hideCard($(this));
    });

     */

});