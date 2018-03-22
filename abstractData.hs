module AbstractData where

-- Structs for HuffmanNode
type Letter = Char
type Value = Float
type HuffmanNode = (Letter, Value)

-- Functions for manipulate HuffmanNode
getFistElement (x,_) = x
getSecondElement(_,x) = x
