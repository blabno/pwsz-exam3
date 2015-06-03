/* exported rumble */
function Donkey()
{

}
Donkey.prototype.makeHungry = function ()
{
    'use strict';
    this.hungry = true;
};
Donkey.prototype.giveHay = function ()
{
    'use strict';
    this.hungry = false;
};
Donkey.prototype.makeSound = function () {
    'use strict';
    var noise = 'u-a-a';
    if (this.hungry) {
        noise = 'banana';
        return noise;
    }
};
function rumble()
{
    'use strict';
    return 'wofbrrrriiiitrututu';
}
