module Start where
import Control.Arrow
import Data.List
import System.IO (readFile)
import Data.Function

data HuffTree  = Leaf Int Char
                       | Fork Int HuffTree HuffTree
                       deriving (Show)

-- Main menu that let user choose between compressing and decompressing files
start :: IO ()
start = do  putStrLn "Menu Principal Huffman  ";
            putStrLn "\t1 - Quero comprimir meu arquivo";
            putStrLn "\t2 - Quero descomprimir meu arquivo";
            putStrLn "\t3 - Quero sair do programa";
            opcao <- getLine;
            case opcao of
                 "1" -> encode;
                 "2" -> putStrLn "Descompressão de arquivo ainda não foi implementada";
                 otherwise -> putStrLn "Saindo...";

-- User chooses file to be compressed
encode :: IO ()
encode = do putStrLn "Digite o nome do arquivo";
            fileName <- getLine
            file <- readFile fileName
            let list = buildTree (sortingList (elementFrequency file))
            print list
            putStrLn "Implementação incompleta, ainda não é comprimido o arquivo!"
            putStrLn "... Aperte enter para retornar ao menu principal"
            getLine
            start

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
