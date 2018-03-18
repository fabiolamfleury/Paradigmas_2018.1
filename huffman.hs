

getFather :: (Int) -> Int
getFather (x) = div x 2

getSonRight :: Int -> Int
getSonRight x = 2*x + 1

getSonLeft :: Int -> Int
getSonLeft x = 2*x


swap :: (Int,Int,[Int]) -> [Int]
swap (positionA, positionB,  xs) =
      let tmpA =  xs !! positionA
          tmpB =  xs !! positionB
          left = take positionB xs
          middle = take(positionA - positionB - 1) (drop (positionB + 1) xs)
          right = drop (positionA + 1 )xs
      in left ++ [tmpA] ++ middle ++ [tmpB] ++ right


heapifyUp :: (Int , [Int]) -> [Int]

heapifyUp (index, xs)
    -- acessando valores na lista
       |(!!)xs index >  xs !! getFather(index) =
          swap(index, getFather(index), xs)
      |(!!)xs index >  xs !! getFather(index) =
          heapifyUp (getFather(index), xs)
      | otherwise =  xs
