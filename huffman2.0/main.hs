module Start where
import Control.Arrow
import Data.List


start :: String -> IO()
start text = putStrLn text

-- Count each char frequency and group it by type (sorting in  ascii order)
elementFrequency :: Ord a => [a] -> [(a, Int)]
elementFrequency = map (head &&& length) . group . sort
