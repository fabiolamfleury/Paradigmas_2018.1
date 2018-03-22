--module AbstractData where
type Letter = Char
type Value = Float

data Huffman = HuffmanNode Letter Value
               deriving(Show)

huffmanNode = HuffmanNode 'c' 4.8
