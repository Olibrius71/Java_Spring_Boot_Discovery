import {Card} from "./card.js";

$(document).ready(function() {

    let progessBarTime = 30; // en secondes
    let timeToSeeCards = 2.5; // en secondes

    let nbPairsFound = 0;      // nombre de paires trouvées, chiffre de 0 à 12

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

            if (currentPbValue == 0) {
                clearInterval(progBarTimeRunning);
                endGameSaveData();
            }
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


    function hideCard(cardToHide) {    // Ca récupère l'élément HTML de l'image de la carte retournée mais il faut d'abord animer la normale
        cardToHide.next().toggle("blind", function () {
            cardToHide.toggle("blind");
        });
    }

    function showCard(cardToShow) {  // Ca récupérera l'élément HTML de l'image de la carte retournée
        cardToShow.toggle("blind", function () {
            cardToShow.next().toggle("blind");
        });
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

    // card_backside est tout le temps le first-child et la carte avec la valeur affectée le last-child
    // la méthode hideAllcards change la propriété display des cartes

    // Tant que l'animation est pas finie, un autre tag img sera créé entre les 2 et supprimé à la fin
    // de l'animation donc il faut un seul next() si l'animation est finie et 2 si elle l'est pas encore

    let cardsPathsOfPairsFound = [];

    let selectedCard = null;
    let previousSelectedCardBackside = null;

    $(".game-card-container > img:first-child").click( function () {

        if (cardsPathsOfPairsFound.includes($(this).attr("src"))) { // Pour sortir du lstener si on a cliqué sur une carte d'une paire déjà révélée
            console.log(cardsPathsOfPairsFound);
            return;
        }

        showCard($(this));

        let selectedCardBackside = $(this);


        setTimeout( function () {   // Pour que le reste soit exécuté dès que l'animation est terminée

            if (selectedCard == null) {
                selectedCard = new Card(selectedCardBackside.next().attr("src"));
                previousSelectedCardBackside = selectedCardBackside;
            } else {
                let newCard = new Card(selectedCardBackside.next().attr("src"));
                if (selectedCard.isPair(newCard)) {
                    nbPairsFound++;
                    cardsPathsOfPairsFound.push(selectedCardBackside.next().attr("src"));
                    cardsPathsOfPairsFound.push(previousSelectedCardBackside.next().attr("src"));
                } else {
                    hideCard(selectedCardBackside);
                    hideCard(previousSelectedCardBackside);
                }
                selectedCard = null;
                previousSelectedCardBackside = null;
            }
        }, 1100);
    });

    function endGameSaveData() {
        console.log("END OF GAME");
        if (nbPairsFound === 12) {
            $.ajax({
                url: "save-game-data",
                type: "POST",
                data: {
                    victory: true,
                    totalTime: progessBarTime,
                    timeToSeeCards: timeToSeeCards,
                    timeToWin: $(".game-time-progress-bar").progressbar("option", "value")
                },
                success: function () {
                    setTimeout(() => {
                        window.location.href = "/";
                    }, 2000);
                }
            });
        }
        else {
            $.ajax({
                url: "save-game-data",
                type: "POST",
                data: {
                    victory: false,
                    totalTime: progessBarTime,
                    timeToSeeCards: timeToSeeCards,
                    nbPairsFound: nbPairsFound
                },
                success: function (response) {
                    setTimeout(() => {
                        window.location.href = "/";
                    }, 2000);
                }
            });
        }
    }
});