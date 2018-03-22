
import Data.List
getFather :: (Int) -> Int
getFather (x) = div x 2

getSonRight :: Int -> Int
getSonRight x = 2*x + 1

getSonLeft :: Int -> Int
getSonLeft x = 2*x

swap :: (Int , Int , [Int]) -> [Int]
swap (i, j, xs) | i == j  = xs
swap (i, j ,xs) |otherwise = left ++ (xs !! b) : middle ++ (xs !! a) : right
                  where [a,b] = sort[i,j]
                        left = take a xs
                        middle = take (b - a - 1) (drop (a + 1) xs)
                        right = drop (b + 1) xs


heapifyUp :: (Int , [Int]) -> [Int]
heapifyUp (i, xs) =
          if (xs !! i) > (xs !! f) then swap(i,f,xs)
          else xs
          where f = getFather(i)
