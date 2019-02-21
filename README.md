# GOFPatternsHm
Homework project with GoF patterns implementation.

Project main idea: implement some kind of automated game where some fractions interacting with each 
other using randomly generated data through GoF patterns.

GoF patterns used: 1 creational, 1 structural, 4 behaviour patterns
Creational: Singletone - which represents Trading Company with which fractions can trade to increase 
their army amount.
Structural: Decorator - represents possibility to build streets which increases population amount and 
'decorate' this logic with possibility to build city.
Behaviour: Memento - saves fraction status after each round, gives a possibility to know how much rounds
passed and output all fraction current status each 10 rounds.
           Iterator- allows to go through all fractions
           Strategy- allows fractions to negotiate what increases their reputarion, there is 2 different 
                     strategies of negotiations, aggressive and peaceful, difference is in amount of 
                     reputation increased from strategy.
           Template method- allows fractions to have some basic abilities, like have race and faith.
           
Application class which has main method is a logic class which randomly generates numbers and do something
with those numbers. No input needed.
