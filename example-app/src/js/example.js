import { SunmiBroadcast } from 'capacitor-sunmi-broadcast';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    SunmiBroadcast.echo({ value: inputValue })
}
