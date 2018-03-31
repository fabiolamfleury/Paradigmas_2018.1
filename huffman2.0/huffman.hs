module Huffman where
import Control.Arrow
import Data.List
import System.IO (readFile)
import Data.Function

-- type HuffmanNode = (String, Int)
data HuffTree  = Leaf Int Char
                       | Fork Int HuffTree HuffTree
                       deriving (Show)

-- Count each char frequency and group it by type (sorting in  ascii order)
elementFrequency :: Ord a => [a] -> [(Int, a)]
elementFrequency = map (length &&& head) . group . sort

-- Sorting list using type's frequency
sortingList :: Ord b1 => [(b1, b)] -> [(b1, b)]
sortingList list = sortOn fst list

getFrequency :: HuffTree -> Int
getFrequency (Leaf frequency _) = frequency
getFrequency (Fork frequency _ _ ) = frequency

mergeElements :: HuffTree -> HuffTree -> HuffTree
mergeElements tree1  tree2 = Fork (getFrequency tree1 + getFrequency tree2)  tree1 tree2

buildTree :: [(Int, Char)] -> HuffTree
buildTree = huffTree . map (uncurry Leaf) . sortBy (compare `on` snd)
             where  huffTree [t]    = t
                    huffTree (a:b:cs)  = huffTree $ insertBy (compare `on` getFrequency) (mergeElements a b) cs

-- Find compress code of each letter using the huffTree
findLetterCode :: HuffTree -> String -> [(Char, String)]
findLetterCode (Leaf _ letter) code = [(letter, code)]
findLetterCode (Fork value huffTreeLeft huffTreeRigth) code = (findLetterCode huffTreeLeft (code ++ "0")) ++ (findLetterCode huffTreeRigth (code ++ "1"))
