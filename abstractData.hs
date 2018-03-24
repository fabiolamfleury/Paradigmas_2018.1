module AbstractData where

-- Structs for HuffmanNode
type Letter = Char
type Value = Float
type Frequence = Int
type HuffmanNode = (Letter, Value, Frequence)

--Functions for manipulate HuffmanNode
getCharHuffman (x,_,_) = x
getFloatHuffman(_,x,_) = x
getIntHuffman(_,_,x) = x
