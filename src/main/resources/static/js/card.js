export class Card {

    // cardPath:  le chemin de la carte
    // cardNumber: le nombre de la carte  (9, 10, J, Q, K, A)
    // cardColor:  la couleur de la carte (noir ou rouge)

    constructor(cardPath) {
        this.cardPath = cardPath;

        let pathParts = cardPath.split("_");

        switch (pathParts[0]) {
            case "9": this.cardNumber = "9";  break;
            case "10": this.cardNumber = "10";  break;
            case "jack": this.cardNumber = "J";  break;
            case "queen": this.cardNumber = "Q";  break;
            case "king": this.cardNumber = "K";  break;
            case "ace": this.cardNumber = "A";  break;
        }

        switch (pathParts[2]) {
            case "clubs.png": this.cardColor = "CLUBS";  break;
            case "diamonds.png": this.cardColor = "DIAMONDS";  break;
            case "hearts.png": this.cardColor = "HEARTS";  break;
            case "spades.png": this.cardColor = "SPADES";  break;
        }
    }

    getNumber() {
        return this.cardNumber;
    }

    getColor() {
        return this.cardColor;
    }

    isPair(otherCard) {
        return otherCard.cardNumber == this.cardNumber && otherCard.cardColor == this.cardColor;
    }
}