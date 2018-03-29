module Start where
import Control.Arrow
import Data.List

import Control.Arrow
import Data.List
import qualified Data.Map
import Data.Function

data HuffTree  = Leaf Int Char
                       | Fork Int HuffTree HuffTree
                       deriving (Show)

start :: Ord b => [b] -> [(Int, b)]
start text = sortingList list
              where list = elementFrequency text

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

 buildTree :: [(Char, Int)] -> HuffTree
 buildTree = bld . map (uncurry Leaf) . sortBy (compare `on` snd)
     where  bld (t:[])    = t
            bld (a:b:cs)  = bld $ insertBy (compare `on` fst) (mergeElements a b) cs
