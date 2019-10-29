"use strict";




//_____________________________________________________________

class EventManager {
    static eventList = new Map();

    static addListener(event, obj, handler) {
        if (this.eventList.has(event)) {
            this.eventList.get(event).push({ obj: obj, handler: handler });
        } else {
            this.eventList.set(event, [{ obj: obj, handler: handler }]);
        }
    }

    static removeListener(event, obj) {
        if (!this.eventList.has(event)) return;
        let filteredEvents = this.eventList.get(event).filter(element => {
            if (element.obj !== obj) return true;
    });

        this.eventList.set(event, filteredEvents);
        console.log(this.eventList.get(event));
    }

    static raiseEvent(event, ...args) {
    if (!this.eventList.has(event)) return;
    this.eventList.get(event).forEach(element => {
    element.handler.apply(element.obj, args);
});
}
}

//_____________________________________________________________

class DateHelper {
    static getFormattedTime(mseconds) {
        let sec = Math.round(mseconds / 1000) % 60;
        let min = Math.floor(mseconds / 1000 / 60) % 60;
        let hour = Math.floor(mseconds / 1000 / 3600) % 24;

        if (sec.toString().length === 1) sec = "0" + sec;
        if (min.toString().length === 1) min = "0" + min;
        if (hour.toString().length === 1) hour = "0" + hour;

        return `${hour}:${min}:${sec}`;
    }
}

//_____________________________________________________________

class PluralModifier {
    static convertToPlural(text, number) {
        let lastNumberInText;

        if (text < 9) {
            lastNumberInText = number;
        } else {
            lastNumberInText = number.toString().slice(-2);
            if (lastNumberInText > 20) {
                lastNumberInText = number.toString().slice(-1);
            }
        }

        if (lastNumberInText === 1) {
            return text;
        } else if (lastNumberInText > 1 && lastNumberInText < 5) {
            return text + "а";
        } else {
            return text + "ов";
        }
    }
}