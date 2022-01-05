# lang-learn-app

lang-learn-app is a lil winter break project created to learn more about using Android Studio and using different... things.
I also wanted to learn how to read Japanese for the longest time, but found most apps on the app store move to quickly or cover
too much at once, so I decided to make my own for my own purposes.
It is not complete nor the most efficient (there are still changes to be done), but general goals were met.

## Description
_____________
It is a very basic version of a language learning phone application intended to help users learn how to read and
recognize Japanese characters (hiragana/katakana)
- not efficient for actually learning to speak, but just character recognition.

Still thinking about how to optimize how I've written and organized the code as I believe there are superfluous parts that can be
combined or changed (but for now, this is what I got).

Data: contains the characters/words for the flash cards & classes that initalize said words.
flash: contains the code for the character flash cards (character practice buttons)
HomeOptions: contains the rest of the buttons available on the home screen (now looking at it, flash should be in here)
  - Hiragana: contains the hiragana options
  - Katakana: contains the katakana options
test: contains the flash card classes for practice tests
  - Pages: contains the redirects to correct/incorrect and the final scoring page
ui: the pages for the homepage navigation side bar
  - home: for home
  - kana: for the kana chart
  - saved: for the saved section
Other: main activity & settings (settings is currently useless, just a placeholder to test things out).

## Current Issues:
- When deleting items from saved, they remain bookmarked when they shouldn't be (simple fix, just need to get to it)
- Vocab mistakes (theoretically simple, but there are a lot of words and I actually don't know japanese)
- Work on database to save after close
- Formatting issues: emulator is a generic phone and works fine, but I have a phone with a skinny screen
    which is useful cause some pages get messed up and look wonky.


## Requirements
_____________

No special requirements necessary. 
However, for the TTS to work on an android device, the Google TTS engine needs
to be the default (more relevant for Samsung devices).


## Referenced Items
_________________
For populating the saved list:
https://github.com/gifffert/FavoriteList/tree/master/app/src/main/java/ru/embersoft/favoritelist
^also helped me figure out how adapters worked
