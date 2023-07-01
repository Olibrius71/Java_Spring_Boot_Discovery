$(document).ready(function() {

    $(".game-time-progress-bar").progressbar({
        value: 100,
        classes: {
            "ui-progressbar-value": "ui-corner-all"
        }
    });

    let pbTime = 30;
    let intervalUpdate = pbTime * 1000 / 100;

    let progBarTimeRunning = setInterval(() => {
        console.log("loop");
        let currentPbValue = $(".game-time-progress-bar").progressbar("option", "value");
        console.log(currentPbValue);
        $(".game-time-progress-bar").progressbar("option", "value", currentPbValue - 1);

        if (currentPbValue == 0) clearInterval(progBarTimeRunning);
    },intervalUpdate);

});