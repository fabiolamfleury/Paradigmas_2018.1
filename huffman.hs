

getFather :: Int -> Int
getFather x = div x 2

getSonRight :: Int -> Int
getSonRight x = 2*x + 1

getSonLeft :: Int -> Int
getSonLeft x = 2*x


swap :: Int -> Int -> [Int] -> [Int]
swap positionA positionB xs =
      let tmpA =  (!!) xs positionA
          tmpB =  (!!) xs  positionB
          left = take positionB xs
          middle = take(positionA - positionB - 1) (drop (positionB + 1) xs)
          right = drop (positionA + 1 )xs
          in left ++ [tmpA] ++ middle ++ [tmpB] ++ right


heapifyUp :: Int -> [Int] -> [Int]

heapifyUp index xs = index == 1
heapifyUp index xs =
    -- acessando valores na lista
      if (!!)xs index > (!!)xs getFather index then
            swap index getFather index xs
            heapifyUp getFather index xs
      else
          heapifyUp getFather index xs
