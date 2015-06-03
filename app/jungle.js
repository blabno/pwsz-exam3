function Donkey()
{

}
Donkey.prototype.makeHungry = function ()
{
    this.hungry = true;
}
Donkey.prototype.giveHay = function ()
{
    this.hungry = false;
}
Donkey.prototype.makeSound = function ()
{
    var noise = 'u-a-a';
    if (this.hungry) {
        noise = 'banana'
        return noise;
    }
}
function rumble()
{
    return 'wofbrrrriiiitrututu';
}
