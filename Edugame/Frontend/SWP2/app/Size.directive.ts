import {Directive,ElementRef,Renderer} from 'angular2/core'
@Directive({
    selector : '[size]',
    host: {
        '(focus)' : 'onFocus()',
        '(blur)' : 'onBlur()'
    }
})
export class Sizedirective{
    //_el : ElementRef; _for indicate private 
    //we will use a short way, here it is
    constructor(private el : ElementRef,private renderer : Renderer){
        //this._el=el;

    }
    onFocus(){
        this.renderer.setElementStyle(this.el.nativeElement,'width','300');
    }
    onBlur(){
        this.renderer.setElementStyle(this.el.nativeElement,'width','200');

    }
}