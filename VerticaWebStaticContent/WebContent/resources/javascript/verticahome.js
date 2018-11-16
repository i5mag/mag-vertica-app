function initiateClock() {
    var today = new Date();
    var hours = today.getHours();
    var minutes = today.getMinutes();
    var seconds = today.getSeconds();
    document.getElementById('clock').innerHTML = hours + ":" + minutes + ":" + seconds;
    var t = setTimeout(initiateClock, 500);
}