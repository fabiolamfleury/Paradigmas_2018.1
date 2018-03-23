module Heap where

import Data.List
import AbstractData

getFather :: (Int) -> Int
getFather (x) = div x 2

getSonRight :: Int -> Int
getSonRight x = 2*x + 1

getSonLeft :: Int -> Int
getSonLeft x = 2*x

swap :: (Int , Int , [HuffmanNode]) -> [HuffmanNode]
swap (i, j, xs) | i == j  = xs
swap (i, j ,xs) |otherwise = left ++ (xs !! b) : middle ++ (xs !! a) : right
                  where [a,b] = sort[i,j]
                        left = take a xs
                        middle = take (b - a - 1) (drop (a + 1) xs)
                        right = drop (b + 1) xs


heapifyUp :: (Int , [HuffmanNode]) -> [HuffmanNode]
heapifyUp (i, xs) =
          if v > u then swap(i,f,xs)
          else xs
          -- Get Numeric part of huffmanNode
          where f = getFather(i)
                v = getSecondElement(xs !! i)
                u = getSecondElement(xs !! f)
