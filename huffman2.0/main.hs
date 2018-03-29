module Start where
import Control.Arrow
import Data.List

start :: Ord b => [b] -> [(Int, b)]
start text = sortingList list
              where list = elementFrequency text

-- Count each char frequency and group it by type (sorting in  ascii order)
elementFrequency :: Ord a => [a] -> [(Int, a)]
elementFrequency = map (length &&& head) . group . sort

-- Sorting list using type's frequency 
sortingList :: Ord b1 => [(b1, b)] -> [(b1, b)]
sortingList list = sortOn fst list
