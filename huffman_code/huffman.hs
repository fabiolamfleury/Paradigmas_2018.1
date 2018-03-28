module Huffman where
import AbstractData

countLetter ::([Char],[Char],[HuffmanNode]) -> [HuffmanNode]
countLetter([],xs,xs1) = xs1
--countLetter ((h:t),[],[]) =  [(h,0,1)] ++ countLetter(t,[h],[(h,0,1)])
countLetter ((h:t),xs1,xs)
            |(hasLetter(h,xs1) == True) && (hasHuffmanLetter(h,xs) == False) = do
                   countLetter(t,xs1,xs ++ [(h,0,count(h,t))])
            |otherwise = countLetter(t,xs1,xs)


hasHuffmanLetter ::(Char,[HuffmanNode]) -> Bool
hasHuffmanLetter (char, []) = False
hasHuffmanLetter (char, (h:t))
                  |char == v = True
                  |otherwise = hasHuffmanLetter(char,t)
                    where v = getCharHuffman(h)


count :: (Char,[Char]) -> Int
count(char,[]) = 1

count (char,(h:t))
      | char == h = 1 + count(char,t)
      |otherwise = count(char,t)

hasLetter :: (Char,[Char]) -> Bool
hasLetter(char,[]) = False
hasLetter(char,[x])
          | char == x = True
          |otherwise = False

hasLetter(char,(h:t))
         | char == h = True
         |otherwise = hasLetter(char,t)


getTotal :: ([HuffmanNode]) -> Int
getTotal([]) = 0
getTotal ((h:t)) = v + getTotal(t)
                  where v = getIntHuffman(h)

calculatePercente :: ([HuffmanNode],Int) -> [HuffmanNode]
calculatePercente([],v) = []
calculatePercente((h:t),v) =
               [(u,d,a)] ++ calculatePercente(t,v)
                       where a = getIntHuffman(h)
                             u = getCharHuffman(h)
                             d =  (fromIntegral a / fromIntegral v)
