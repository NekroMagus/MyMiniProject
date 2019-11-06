export default class DoubleSlider {

    constructor(params) {
        this.track = params.track;
        this.handleOne = params.handleOne;
        this.handleTwo = params.handleTwo;
        this.rangeLine = params.rangeLine;

        this.currentHandle = null;
        this.currentHandleRect = null;
        this.trackRect = params.track.getBoundingClientRect();
        this.handleOneRect = params.handleOne.getBoundingClientRect();
        this.handleTwoRect = params.handleTwo.getBoundingClientRect();
        this.value = { min: 0, max: 1 };

        this.setHandlesPosition();

        this.addListeners();
        this.handleEvent = this.classEventHandler;
    }

    // METHODS _________________________________________________________________

    addListeners() {
        this.handleOne.addEventListener(
            "mousedown",
            this.sliderHandleMouseDown.bind(this)
        );

        this.handleTwo.addEventListener(
            "mousedown",
            this.sliderHandleMouseDown.bind(this)
        );

        this.handleOne.ondragstart = this.handleTwo.ondragstart = () => {
            return false;
        };

        window.addEventListener("resize", this.windowResize.bind(this));
    }

    setHandlesPosition() {
        let x1 =
            this.value.min * this.trackRect.width - this.handleOneRect.width / 2;
        let x2 =
            this.value.max * this.trackRect.width - this.handleTwoRect.width / 2;

        this.handleOne.style.transform = `translateX(${x1}px)`;
        this.handleTwo.style.transform = `translateX(${x2}px)`;
        this.moveRangeLine();
    }

    computeValue() {
        let x1 = this.handleOne.getBoundingClientRect().left - this.trackRect.left;
        let x2 = this.handleTwo.getBoundingClientRect().left - this.trackRect.left;

        let value1 = (x1 + this.handleOneRect.width / 2) / this.trackRect.width;
        let value2 = (x2 + this.handleTwoRect.width / 2) / this.trackRect.width;

        this.value = {
            min: Math.min(value1, value2),
            max: Math.max(value1, value2)
        };

        this.track.dispatchEvent(
            new CustomEvent("onDoubleSliderChangeValue", {
                detail: { value: this.value },
                bubbles: true
            })
        );
    }

    setValue(min, max) {
        this.value = { min: min, max: max };
        this.setHandlesPosition();
    }

    moveRangeLine() {
        let x = this.value.min * this.trackRect.width;
        let width = this.value.max * this.trackRect.width - x;

        this.rangeLine.style.transform = `translateX(${x}px)`;
        this.rangeLine.style.width = `${width}px`;
    }
    // HANDLERS _________________________________________________________________

    classEventHandler(e) {
        switch (e.type) {
            case "mousemove":
                this.documentMouseMove(e);
                break;
            case "mouseup":
                this.documentMouseUp(e);
                break;
        }
    }

    sliderHandleMouseDown(e) {
        if (e.which !== 1) return;
        this.currentHandle = e.target;
        this.currentHandleRect = this.currentHandle.getBoundingClientRect();

        document.addEventListener("mousemove", this);
        document.addEventListener("mouseup", this);
    }

    documentMouseMove(e) {
        let x = e.pageX - this.trackRect.left - this.currentHandleRect.width / 2;

        if (e.pageX < this.trackRect.left) x = 0 - this.currentHandleRect.width / 2;
        if (e.pageX > this.trackRect.right) {
            x = this.trackRect.width - this.currentHandleRect.width / 2;
        }

        this.currentHandle.style.transform = `translateX(${x}px)`;

        this.computeValue();
        this.moveRangeLine();
    }

    documentMouseUp(e) {
        document.removeEventListener("mousemove", this);
        document.removeEventListener("mouseup", this);
    }

    windowResize() {
        this.trackRect = this.track.getBoundingClientRect();
        this.setHandlesPosition();
    }
}