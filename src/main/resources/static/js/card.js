export class Card {

    // cardPath:  le chemin de la carte
    // cardNumber: le nombre de la carte  (9, 10, J, Q, K, A)
    // cardSymbol:  le symbole de la carte (HEARTS, DIAMONDS, CLUBS, SPADES)
    // cardColor: la couleur de la carte (noir ou rouge)

    constructor(cardPath) {
        this.cardPath = cardPath;

        let pathParts = cardPath.split("_");


        pathParts[0] = pathParts[0].replace("images/cards/","")
        switch (pathParts[0]) {
            case "9": this.cardNumber = "9";  break;
            case "10": this.cardNumber = "10";  break;
            case "jack": this.cardNumber = "J";  break;
            case "queen": this.cardNumber = "Q";  break;
            case "king": this.cardNumber = "K";  break;
            case "ace": this.cardNumber = "A";  break;
        }

        switch (pathParts[2]) {
            case "clubs.png":
                this.cardSymbol = "CLUBS";
                this.cardColor = "BLACK";   break;
            case "diamonds.png":
                this.cardSymbol = "DIAMONDS";
                this.cardColor = "RED";   break;
            case "hearts.png":
                this.cardSymbol = "HEARTS";
                this.cardColor = "RED";   break;
            case "spades.png":
                this.cardSymbol = "SPADES";
                this.cardColor = "BLACK";    break;
        }
    }

    getNumber() {
        return this.cardNumber;
    }

    getColor() {
        return this.cardColor;
    }

    getSymbol() {
        return this.cardSymbol;
    }

    isPair(otherCard) {
        return otherCard.cardNumber == this.cardNumber && otherCard.cardColor == this.cardColor;
    }
}