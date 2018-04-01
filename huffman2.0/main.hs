module Start where
import System.IO (readFile, hClose)
import Control.Exception
import System.IO.Error
import Data.Function
import Huffman
import File

-- Main menu that let user choose between compressing and decompressing files
start :: IO ()
start = do  putStrLn "Menu Principal Huffman  ";
            putStrLn "\t1 - Quero comprimir meu arquivo";
            putStrLn "\t2 - Quero descomprimir meu arquivo";
            putStrLn "\t3 - Quero sair do programa";
            opcao <- getLine;
            case opcao of
                 "1" -> encode;
                 "2" -> decode;

 -- User chooses file to be compressed
encode :: IO ()
encode = do
            {catch (tryRead) exception;}
            where
                  tryRead = do
                    putStrLn "Digite o nome do arquivo";
                    fileName <- getLine
                    file <- readFile fileName
                    let list = buildTree (sortingList (elementFrequency file))
                    print list
                    let lettersCode = findLetterCode list ""
                    print lettersCode
                    writeCodeInFile file "out.txt" lettersCode ""
                    writeTree list
                    putStrLn "... Aperte enter para retornar ao menu principal"
                    getLine
                    start
                  exception erro = if isDoesNotExistError erro
                          then do
                            putStrLn "Arquivo não encontrado";
                            encode
                  else ioError erro


find :: ([Char],HuffTree) -> [Char]
find(xs, Leaf _ letter) = [letter]
find(h:t,Fork value left right) = if h == '0' then find(t,left) ++ find(t,right)
                                                    else find(t,right) ++ find(t,left)

parse :: [Char] -> HuffTree
parse a = read a :: HuffTree
decode :: IO()
decode = do
         file <- readFile "tree.txt"
         fileA <- readFile "out.txt"
         print fileA
         let a = parse file
             b = find(fileA,a)
          in print b
