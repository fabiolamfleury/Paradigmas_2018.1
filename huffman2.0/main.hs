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
                 "2" -> putStrLn "Descompressão de arquivo ainda não foi implementada";
                 otherwise -> putStrLn "Saindo...";

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
                    putStrLn "... Aperte enter para retornar ao menu principal"
                    getLine
                    start
                  exception erro = if isDoesNotExistError erro
                          then do
                            putStrLn "Arquivo não encontrado";
                            encode
                  else ioError erro
