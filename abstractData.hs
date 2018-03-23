module AbstractData where

-- Structs for HuffmanNode
type Letter = Char
type Value = Float
type HuffmanNode = (Letter, Value, Int)

--Functions for manipulate HuffmanNode
getFistElement (x,_,_) = x
getSecondElement(_,x,_) = x
getThirtElement(_,_,x) = x
