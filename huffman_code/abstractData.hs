module AbstractData where

-- Structs for HuffmanNode
type Letter = Char
type Value = Float
type Frequence = Int
type HuffmanNode = (Letter, Frequence)

--Functions for manipulate HuffmanNode
getCharHuffman :: HuffmanNode -> Letter
getCharHuffman (x,_) = x

getIntHuffman :: HuffmanNode -> Frequence
getIntHuffman(_,x) = x
